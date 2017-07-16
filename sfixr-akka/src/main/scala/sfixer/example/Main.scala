package sfixer.example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpMethods, HttpRequest, HttpResponse}
import akka.http.scaladsl.unmarshalling.{FromEntityUnmarshaller, Unmarshal}
import akka.stream.ActorMaterializer
import com.github.nscala_time.time.StaticDateTime
import de.heikoseeberger.akkahttpcirce.CirceSupport
import io.circe.generic.auto._
import sfixer.fixer.FixerAPIEndpoints
import sfixer.models.Rates.AllFixerRates
import sfixer.models._

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}

object Main extends App with CirceSupport{

  implicit val actorsystem = ActorSystem("ayy")
  implicit val materializer = ActorMaterializer()
  implicit val ec: ExecutionContext = actorsystem.dispatcher

  val httpActor = Http()

  /**
   * A historical rate
   */
  val oldRate = HttpRequest(
    uri = FixerAPIEndpoints.getLink[USD](Some(StaticDateTime.parse("2006-06-30"))),
    method = HttpMethods.GET
  )

  /**
   * Latest rate
   *
   */
  val latestRate = HttpRequest(
    uri = FixerAPIEndpoints.default,
    method = HttpMethods.GET
  )

  def consumeToken(httpResponse: HttpResponse)(implicit f: FromEntityUnmarshaller[AllFixerRates]): Future[Rates] = {
    Unmarshal(httpResponse).to[AllFixerRates]
  }

  implicit val newRates = Await.result(httpActor.singleRequest(latestRate).flatMap(consumeToken), 10 seconds)
  val oldRates: Rates = Await.result(httpActor.singleRequest(oldRate).flatMap(consumeToken), 10 seconds)

  val usd = USD(100)
  val eur: EUR = usd.convertTo[EUR] // Convert to boxed
  val backwards: CurrencyValue = eur.convertToValue[USD] //Convert To Straight value
  val oldEuros: EUR = usd.convertTo[EUR](oldRates)//Pass rates explicitly

  Await.result(actorsystem.terminate(), Duration.Inf)

}

