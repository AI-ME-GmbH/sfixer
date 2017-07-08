package sfixer.models

import io.circe._
import io.circe.generic.auto._



/**
 * Base value class around which we pivot
 *
 */
sealed trait Rates {
  def base: String
  def date: String
  def rates: Map[String, CurrencyValue]
  def rate[A <: Currency](implicit c: CurrencyOps[A]): CurrencyValue = {
    if (c.identifier == base)
      1
    else
      rates(c.identifier)
  }
}

object Rates {
  /**
   * Total number of supported currencies. This is the number of currencies in our ADT
   *
   */
  private final val TOTAL_CURRENCIES = 32

  final case class AllFixerRates(base: String, date: String, rates: Map[String, CurrencyValue]) extends Rates {
    /**
     * BaseValue should be a pivot for ALL currencies. PartialValues should be for any partial queries, for type safety.
     * The api only returns 31 under rates, and one
     *
     */
    require(rates.size >= (TOTAL_CURRENCIES - 1))
  }

  /**
   * Provide a simple conversion into our sfixer.fixer api
   *
   * @param j
   * @tparam T
   * @return
   */
  def consume[T](j: Json): Option[Rates] = {
    j.as[AllFixerRates].toOption
  }

}
