package common


import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.{Assertion, FlatSpec, Matchers}
import sfixer.models.Rates.AllFixerRates
import sfixer.models._

trait ConversionTestBase extends FlatSpec with Matchers{
  /**
   * Some historical data pulled from fixer.io
   *
   */
  implicit val rates = AllFixerRates(
    base = "EUR",
    date = "2017-07-07",
    rates = Map(
      "AUD" -> 1.5006,
      "BGN" -> 1.9558,
      "BRL" -> 3.7587,
      "CAD" -> 1.4806,
      "CHF" -> 1.0983,
      "CNY" -> 7.759,
      "CZK" -> 26.079,
      "DKK" -> 7.4371,
      "GBP" -> 0.88488,
      "HKD" -> 8.914,
      "HRK" -> 7.4153,
      "HUF" -> 308.38,
      "IDR" -> 15301.0,
      "ILS" -> 4.0273,
      "INR" -> 73.696,
      "JPY" -> 129.8,
      "KRW" -> 1318.1,
      "MXN" -> 20.749,
      "MYR" -> 4.9054,
      "NOK" -> 9.5613,
      "NZD" -> 1.5669,
      "PHP" -> 57.786,
      "PLN" -> 4.2322,
      "RON" -> 4.5862,
      "RUB" -> 68.919,
      "SEK" -> 9.6155,
      "SGD" -> 1.5761,
      "THB" -> 38.892,
      "TRY" -> 4.1465,
      "USD" -> 1.1412,
      "ZAR" -> 15.266
    )
  )

  /*
   Our currency generator. Note: We are testing only between -1E30 and 1E30
   */
  implicit val arbitraryCurrency: Arbitrary[Currency] = Arbitrary(for {
    k <- Gen.oneOf(rates.rates.keys.toSeq)
    v <- Gen.choose(-1E30, 1E30)
  } yield Currency.smash(k)(v))

  val TOLERANCE = BigDecimal(0.001)

  def tolerance(a: Currency, b: Currency): Assertion = a.amount should (be <= (b.amount + TOLERANCE) and be >= (b.amount - TOLERANCE))
}
