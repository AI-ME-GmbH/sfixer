package models

import io.circe._
import io.circe.generic.auto._
import java.time.LocalDateTime

import com.github.nscala_time.time.StaticDateTime
import org.joda.time.DateTime



/**
 * Base value class
 *
 * @tparam T
 */
sealed trait BaseValue {
  import Currency._
  def base: String
  def date: DateTime
  def rates: Map[String, Double]
  def rate[A <: Currency](implicit c: CurrencyConverter[A]): Value = {
    if (c.identifier == base)
      1
    else
      rates(c.identifier)
  }
}

object BaseValue {
  final case class FixerAPI(base: String, date: String, rates: Map[String, Double])

  def consume[T](j: Json): BaseValue = {
    val consumed = j.as[FixerAPI].fold(_ => throw new IllegalArgumentException, c => c)
    new BaseValue {
      lazy val date: DateTime = StaticDateTime.parse(consumed.date)

      lazy val rates: Map[String, Double] = consumed.rates

      lazy val base: String = consumed.base
    }
  }
}
