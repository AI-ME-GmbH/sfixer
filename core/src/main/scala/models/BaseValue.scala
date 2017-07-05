package models

import io.circe._
import io.circe.generic.auto._



/**
 * Base value class around which we pivot
 *
 */
sealed trait BaseValue {
  def base: String
  def date: String
  def rates: Map[String, Value]
  def rate[A <: Currency](implicit c: CurrencyOps[A]): Value = {
    if (c.identifier == base)
      1
    else
      rates(c.identifier)
  }
}

object BaseValue {
  final case class FixerAPI(base: String, date: String, rates: Map[String, Value]) extends BaseValue

  /**
   * Provide a simple conversion into our fixer api
   *
   * @param j
   * @tparam T
   * @return
   */
  def consume[T](j: Json): Option[BaseValue] = {
    j.as[FixerAPI].fold(_ => None, Some.apply)
  }
}
