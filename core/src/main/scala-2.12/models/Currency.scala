package models

/**
 * Our currency implementations
 *
 */
import Currency._

sealed trait Currency {
    def amount: Value
}

/**
 * Our converting type class
 *
 * @tparam T
 */
sealed trait CurrencyConverter[T <: Currency]{
    def identifier: String
    def to[B <: Currency](currencyA: T)(implicit currencyConverter: CurrencyConverter[B], baseValue: BaseValue): Value = (currencyA * baseValue) / baseValue.rate[B]
}

case class Euro(amount: Value) extends Currency

object Euro{
    val prefix: String = "EUR"
    implicit val converter: CurrencyConverter[Euro] = Currency.deriveConverter[Euro](prefix)
}

case class AUD(amount: Value) extends Currency

object AUD {
    val prefix: String = "AUD"
    implicit val converter: CurrencyConverter[AUD] = Currency.deriveConverter[AUD](prefix)
}

case class USD(amount: Value) extends Currency

object USD{
    val prefix = "USD"
    implicit val converter: CurrencyConverter[USD] = Currency.deriveConverter[USD](prefix)
}

case class CAD(amount: Value) extends Currency

object CAD {
    val prefix = "CAD"
    implicit val converter: CurrencyConverter[CAD] = Currency.deriveConverter[CAD](prefix)
}

object Currency {
    type Value = Double

    def deriveConverter[T <: Currency](ident: String): CurrencyConverter[T] = new CurrencyConverter[T]{
        val identifier = ident
    }

    def smash(identifier: String)(value: Value): Currency = {
        identifier match {
            case USD.prefix => USD(value)
            case Euro.prefix => Euro(value)
            case AUD.prefix => AUD(value)
            case _ => throw new IllegalArgumentException
        }
    }

    private [this] def convertGeneric[Target <: Currency : CurrencyConverter](a: Currency)(implicit b: BaseValue): Value = a match {
        case h: USD => h.convertTo[Target]
        case h: Euro => h.convertTo[Target]
        case h: AUD => h.convertTo[Target]
        case c: CAD => c.convertTo[Target]
    }

    /**
     * Operations on currency
     *
     * @param c
     * @tparam A
     */
    implicit class ConverterOps[A <: Currency](c: A) {
        def convertTo[B <: Currency](implicit c1: CurrencyConverter[A], c2: CurrencyConverter[B], b: BaseValue): Value = {
            c1.to[B](c)
        }

        def *[T <: Currency : CurrencyConverter](baseValue: BaseValue): Value = c.amount * baseValue.rate[T]
    }

    /**
     * Operations on currency
     *
     * @param a
     */
    implicit class CurrencyOps(a: Currency) {
        def convertGenericTo[T <: Currency : CurrencyConverter](implicit b: BaseValue): Value = convertGeneric[T](a)
    }
}