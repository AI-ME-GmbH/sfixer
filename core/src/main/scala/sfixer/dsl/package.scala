package sfixer

import sfixer.models._

/*
(ง ͠° ͟ل͜ ͡°)ง ᴍᴀsᴛᴇʀ ʏᴏᴜʀ ᴅSL, ᴍᴀsᴛᴇʀ ᴛʜᴇ ᴇɴᴇᴍʏ (ง ͠° ͟ل͜ ͡°)ง
 */
package object dsl {

  /**
   * Our Currency DSL
   * All DSL operations are left operand biased, meaning conversions will happen left to right
   * USD + AUD => USD
   * AUD + USD => AUD
   *
   * USD + CAD + AUD == USD + (CAD + AUD) == (USD + CAD) + AUD
   *
   * @param currency
   * @param c1Ops
   * @tparam A
   */
  implicit class CurrencyDSL[A <: Currency](val currency: A)(implicit c1Ops: CurrencyOps[A]) {

    /*
    Same type elementary operations
     */
    def +(other: A): A = {
      c1Ops(currency.amount + other.amount)
    }

    def -(other: A): A = {
      c1Ops(currency.amount - other.amount)
    }

    def *(other: A): A = {
      c1Ops(currency.amount * other.amount)
    }

    def /(other: A): A = {
      c1Ops(currency.amount / other.amount)
    }

    /*
    Elementary ops with implicit rate
     */
    def +[B <: Currency : CurrencyOps](other: B)(implicit r: Rates): A = {
      c1Ops(currency.amount + other.convertToValue[A])
    }

    def -[B <: Currency : CurrencyOps](other: B)(implicit r: Rates): A = {
      c1Ops(currency.amount - other.convertToValue[B])
    }

    def *[B <: Currency : CurrencyOps](other: B)(implicit r: Rates): A = {
      c1Ops(currency.amount * other.convertToValue[B])
    }

    def /[B <: Currency : CurrencyOps](other: B)(implicit r: Rates): A = {
      c1Ops(currency.amount / other.convertToValue[A])
    }

    /*
    Elementary Operations with explicit rate
     */

    def +[B <: Currency : CurrencyOps](other: B, r: Rates): A = {
      c1Ops(currency.amount + other.convertToValue[A](r))
    }

    def /[B <: Currency : CurrencyOps](other: B, r: Rates): A = {
      c1Ops(currency.amount / other.convertToValue[A](r))
    }

    def -[B <: Currency : CurrencyOps](other: B, r: Rates): A = {
      c1Ops(currency.amount - other.convertToValue[A](r))
    }

    def *[B <: Currency : CurrencyOps](other: B, r: Rates): A = {
      c1Ops(currency.amount * other.convertToValue[A](r))
    }
  }

  /*
  DSL for common currencies to wrap numerics
   */
  implicit class IntegerOps(val i: Int) extends AnyVal{
    def usd = USD(i)

    def eur = EUR(i)

    def cad = CAD(i)

    def aud = AUD(i)
  }

  implicit class LongOps(val i: Long) extends AnyVal {
    def usd = USD(i)

    def eur = EUR(i)

    def cad = CAD(i)

    def aud = AUD(i)
  }

  implicit class DoubleOps(val i: Double) extends AnyVal {
    def usd = USD(i)

    def eur = EUR(i)

    def cad = CAD(i)

    def aud = AUD(i)
  }

  implicit class BigDecimalOps(val i: BigDecimal) extends AnyVal {
    def usd = USD(i)

    def eur = EUR(i)

    def cad = CAD(i)

    def aud = AUD(i)
  }

  implicit class FloatOps(val i: Float) extends AnyVal {
    def usd = USD(i.toDouble)

    def eur = EUR(i.toDouble)

    def cad = CAD(i.toDouble)

    def aud = AUD(i.toDouble)
  }

}
