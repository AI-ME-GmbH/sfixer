package models


/**
 * Our converting type class
 *
 * @tparam T
 */
sealed trait CurrencyOps[T <: Currency]{
  def identifier: String
  def to[B <: Currency](currencyA: T)(implicit currencyConverter: CurrencyOps[B], baseValue: BaseValue): Value =
    currencyA.amount * (baseValue.rate[B] / baseValue.rate[T](this))
}

final case class Ops[T <: Currency](identifier: String) extends CurrencyOps[T]
