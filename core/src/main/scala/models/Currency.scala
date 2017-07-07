package models

import scala.reflect.ClassTag

/**
 * Our currency implementations
 *
 */
sealed trait Currency {
    def amount: Value
}

/**
 * Our converting type class
 *
 * @tparam T
 */
sealed trait CurrencyOps[T <: Currency]{
    def identifier: String
    def to[B <: Currency](currencyA: T)(implicit currencyConverter: CurrencyOps[B], baseValue: Rates): Value =
        currencyA.amount * (baseValue.rate[B] / baseValue.rate[T](this))
    def apply(amount: Value): T
}

abstract class DeriveTypeClass[T <: Currency](implicit classTag: ClassTag[T]){
    val prefix: String = classTag.runtimeClass.getSimpleName
}

final case class EUR(amount: Value) extends Currency

object EUR extends DeriveTypeClass[EUR] {

    implicit val converter: CurrencyOps[EUR] = new CurrencyOps[EUR] {

        val identifier: String = prefix

        def apply(amount: Value): EUR = EUR(amount)
    }
}

final case class AUD(amount: Value) extends Currency

object AUD extends DeriveTypeClass[AUD] {

    implicit val converter: CurrencyOps[AUD] = new CurrencyOps[AUD] {

        val identifier: String = prefix

        def apply(amount: Value): AUD = AUD(amount)
    }
}

final case class USD(amount: Value) extends Currency

object USD extends DeriveTypeClass[USD] {

    implicit val converter: CurrencyOps[USD] = new CurrencyOps[USD] {

        val identifier: String = prefix

        def apply(amount: Value): USD = USD(amount)
    }
}

final case class CAD(amount: Value) extends Currency

object CAD extends DeriveTypeClass[CAD] {

    implicit val converter: CurrencyOps[CAD] = new CurrencyOps[CAD] {

        val identifier: String = prefix

        def apply(amount: Value): CAD = CAD(amount)
    }
}

final case class BGN (amount: Value) extends Currency

object BGN extends DeriveTypeClass[BGN] {

    implicit val converter: CurrencyOps[BGN] = new CurrencyOps[BGN] {

        val identifier: String = prefix

        def apply(amount: Value): BGN = BGN(amount)
    }
}

final case class BRL (amount: Value) extends Currency

object BRL extends DeriveTypeClass[BRL] {

    implicit val converter: CurrencyOps[BRL] = new CurrencyOps[BRL] {

        val identifier: String = prefix

        def apply(amount: Value): BRL = BRL(amount)
    }
}

final case class CHF (amount: Value) extends Currency

object CHF extends DeriveTypeClass[CHF] {

    implicit val converter: CurrencyOps[CHF] = new CurrencyOps[CHF] {

        val identifier: String = prefix

        def apply(amount: Value): CHF = CHF(amount)
    }
}

final case class CNY (amount: Value) extends Currency

object CNY extends DeriveTypeClass[CNY] {

    implicit val converter: CurrencyOps[CNY] = new CurrencyOps[CNY] {

        val identifier: String = prefix

        def apply(amount: Value): CNY = CNY(amount)
    }
}

final case class CZK (amount: Value) extends Currency

object CZK extends DeriveTypeClass[CZK] {

    implicit val converter: CurrencyOps[CZK] = new CurrencyOps[CZK] {

        val identifier: String = prefix

        def apply(amount: Value): CZK = CZK(amount)
    }
}

final case class DKK (amount: Value) extends Currency

object DKK extends DeriveTypeClass[DKK] {

    implicit val converter: CurrencyOps[DKK] = new CurrencyOps[DKK] {

        val identifier: String = prefix

        def apply(amount: Value): DKK = DKK(amount)
    }
}

final case class GBP (amount: Value) extends Currency

object GBP extends DeriveTypeClass[GBP] {

    implicit val converter: CurrencyOps[GBP] = new CurrencyOps[GBP] {

        val identifier: String = prefix

        def apply(amount: Value): GBP = GBP(amount)
    }
}

final case class HKD (amount: Value) extends Currency

object HKD extends DeriveTypeClass[HKD] {

    implicit val converter: CurrencyOps[HKD] = new CurrencyOps[HKD] {

        val identifier: String = prefix

        def apply(amount: Value): HKD = HKD(amount)
    }
}

final case class HRK (amount: Value) extends Currency

object HRK extends DeriveTypeClass[HRK] {

    implicit val converter: CurrencyOps[HRK] = new CurrencyOps[HRK] {

        val identifier: String = prefix

        def apply(amount: Value): HRK = HRK(amount)
    }
}

final case class HUF (amount: Value) extends Currency

object HUF extends DeriveTypeClass[HUF] {

    implicit val converter: CurrencyOps[HUF] = new CurrencyOps[HUF] {

        val identifier: String = prefix

        def apply(amount: Value): HUF = HUF(amount)
    }
}

final case class IDR (amount: Value) extends Currency

object IDR extends DeriveTypeClass[IDR] {

    implicit val converter: CurrencyOps[IDR] = new CurrencyOps[IDR] {

        val identifier: String = prefix

        def apply(amount: Value): IDR = IDR(amount)
    }
}

final case class ILS (amount: Value) extends Currency

object ILS extends DeriveTypeClass[ILS] {

    implicit val converter: CurrencyOps[ILS] = new CurrencyOps[ILS] {

        val identifier: String = prefix

        def apply(amount: Value): ILS = ILS(amount)
    }
}

final case class INR (amount: Value) extends Currency

object INR extends DeriveTypeClass[INR] {

    implicit val converter: CurrencyOps[INR] = new CurrencyOps[INR] {

        val identifier: String = prefix

        def apply(amount: Value): INR = INR(amount)
    }
}

final case class JPY (amount: Value) extends Currency

object JPY extends DeriveTypeClass[JPY] {

    implicit val converter: CurrencyOps[JPY] = new CurrencyOps[JPY] {

        val identifier: String = prefix

        def apply(amount: Value): JPY = JPY(amount)
    }
}

final case class KRW (amount: Value) extends Currency

object KRW extends DeriveTypeClass[KRW] {

    implicit val converter: CurrencyOps[KRW] = new CurrencyOps[KRW] {

        val identifier: String = prefix

        def apply(amount: Value): KRW = KRW(amount)
    }
}

final case class MXN (amount: Value) extends Currency

object MXN extends DeriveTypeClass[MXN] {

    implicit val converter: CurrencyOps[MXN] = new CurrencyOps[MXN] {

        val identifier: String = prefix

        def apply(amount: Value): MXN = MXN(amount)
    }
}

final case class MYR (amount: Value) extends Currency

object MYR extends DeriveTypeClass[MYR] {

    implicit val converter: CurrencyOps[MYR] = new CurrencyOps[MYR] {

        val identifier: String = prefix

        def apply(amount: Value): MYR = MYR(amount)
    }
}

final case class NOK (amount: Value) extends Currency

object NOK extends DeriveTypeClass[NOK] {

    implicit val converter: CurrencyOps[NOK] = new CurrencyOps[NOK] {

        val identifier: String = prefix

        def apply(amount: Value): NOK = NOK(amount)
    }
}

final case class NZD (amount: Value) extends Currency

object NZD extends DeriveTypeClass[NZD] {

    implicit val converter: CurrencyOps[NZD] = new CurrencyOps[NZD] {

        val identifier: String = prefix

        def apply(amount: Value): NZD = NZD(amount)
    }
}

final case class PHP (amount: Value) extends Currency

object PHP extends DeriveTypeClass[PHP] {

    implicit val converter: CurrencyOps[PHP] = new CurrencyOps[PHP] {

        val identifier: String = prefix

        def apply(amount: Value): PHP = PHP(amount)
    }
}

final case class PLN (amount: Value) extends Currency

object PLN extends DeriveTypeClass[PLN] {

    implicit val converter: CurrencyOps[PLN] = new CurrencyOps[PLN] {

        val identifier: String = prefix

        def apply(amount: Value): PLN = PLN(amount)
    }
}

final case class RON (amount: Value) extends Currency

object RON extends DeriveTypeClass[RON] {

    implicit val converter: CurrencyOps[RON] = new CurrencyOps[RON] {

        val identifier: String = prefix

        def apply(amount: Value): RON = RON(amount)
    }
}

final case class RUB (amount: Value) extends Currency

object RUB extends DeriveTypeClass[RUB] {

    implicit val converter: CurrencyOps[RUB] = new CurrencyOps[RUB] {

        val identifier: String = prefix

        def apply(amount: Value): RUB = RUB(amount)
    }
}

final case class SEK (amount: Value) extends Currency

object SEK extends DeriveTypeClass[SEK] {

    implicit val converter: CurrencyOps[SEK] = new CurrencyOps[SEK] {

        val identifier: String = prefix

        def apply(amount: Value): SEK = SEK(amount)
    }
}

final case class SGD (amount: Value) extends Currency

object SGD extends DeriveTypeClass[SGD] {

    implicit val converter: CurrencyOps[SGD] = new CurrencyOps[SGD] {

        val identifier: String = prefix

        def apply(amount: Value): SGD = SGD(amount)
    }
}

final case class THB (amount: Value) extends Currency

object THB extends DeriveTypeClass[THB] {

    implicit val converter: CurrencyOps[THB] = new CurrencyOps[THB] {

        val identifier: String = prefix

        def apply(amount: Value): THB = THB(amount)
    }
}

final case class TRY (amount: Value) extends Currency

object TRY extends DeriveTypeClass[TRY] {

    implicit val converter: CurrencyOps[TRY] = new CurrencyOps[TRY] {

        val identifier: String = prefix

        def apply(amount: Value): TRY = TRY(amount)
    }
}

final case class ZAR (amount: Value) extends Currency

object ZAR extends DeriveTypeClass[ZAR] {

    implicit val converter: CurrencyOps[ZAR] = new CurrencyOps[ZAR] {

        val identifier: String = prefix

        def apply(amount: Value): ZAR = ZAR(amount)
    }
}



object Currency {



    /**
     *
     * @param identifier
     * @param value
     * @return
     */
    def smash(identifier: String)(value: Value): Currency = {
        identifier match {
            case EUR.prefix => EUR(value)
            case AUD.prefix => AUD(value)
            case BGN.prefix => BGN(value)
            case BRL.prefix => BRL(value)
            case CAD.prefix => CAD(value)
            case CHF.prefix => CHF(value)
            case CNY.prefix => CNY(value)
            case CZK.prefix => CZK(value)
            case DKK.prefix => DKK(value)
            case GBP.prefix => GBP(value)
            case HKD.prefix => HKD(value)
            case HRK.prefix => HRK(value)
            case HUF.prefix => HUF(value)
            case IDR.prefix => IDR(value)
            case ILS.prefix => ILS(value)
            case INR.prefix => INR(value)
            case JPY.prefix => JPY(value)
            case KRW.prefix => KRW(value)
            case MXN.prefix => MXN(value)
            case MYR.prefix => MYR(value)
            case NOK.prefix => NOK(value)
            case NZD.prefix => NZD(value)
            case PHP.prefix => PHP(value)
            case PLN.prefix => PLN(value)
            case RON.prefix => RON(value)
            case RUB.prefix => RUB(value)
            case SEK.prefix => SEK(value)
            case SGD.prefix => SGD(value)
            case THB.prefix => THB(value)
            case TRY.prefix => TRY(value)
            case USD.prefix => USD(value)
            case ZAR.prefix => ZAR(value)
            case _ => throw new NoSuchElementException
        }
    }

    /**
     * Generic conversions
     *
     * @param a
     * @param b
     * @tparam Target
     * @return
     */
    private [this] def convertGeneric[Target <: Currency : CurrencyOps](a: Currency)(implicit b: Rates): Value = a match {
        case c: EUR => c.convertToValue[Target]
        case c: AUD => c.convertToValue[Target]
        case c: BGN => c.convertToValue[Target]
        case c: BRL => c.convertToValue[Target]
        case c: CAD => c.convertToValue[Target]
        case c: CHF => c.convertToValue[Target]
        case c: CNY => c.convertToValue[Target]
        case c: CZK => c.convertToValue[Target]
        case c: DKK => c.convertToValue[Target]
        case c: GBP => c.convertToValue[Target]
        case c: HKD => c.convertToValue[Target]
        case c: HRK => c.convertToValue[Target]
        case c: HUF => c.convertToValue[Target]
        case c: IDR => c.convertToValue[Target]
        case c: ILS => c.convertToValue[Target]
        case c: INR => c.convertToValue[Target]
        case c: JPY => c.convertToValue[Target]
        case c: KRW => c.convertToValue[Target]
        case c: MXN => c.convertToValue[Target]
        case c: MYR => c.convertToValue[Target]
        case c: NOK => c.convertToValue[Target]
        case c: NZD => c.convertToValue[Target]
        case c: PHP => c.convertToValue[Target]
        case c: PLN => c.convertToValue[Target]
        case c: RON => c.convertToValue[Target]
        case c: RUB => c.convertToValue[Target]
        case c: SEK => c.convertToValue[Target]
        case c: SGD => c.convertToValue[Target]
        case c: THB => c.convertToValue[Target]
        case c: TRY => c.convertToValue[Target]
        case c: USD => c.convertToValue[Target]
        case c: ZAR => c.convertToValue[Target]
    }

    /**
     * Operations on currency
     *
     * @param c
     * @tparam A
     */
    implicit class ConverterOps[A <: Currency](val c: A) extends AnyVal{
        def convertToValue[B <: Currency](implicit c1: CurrencyOps[A], c2: CurrencyOps[B], b: Rates): Value = {
            c1.to[B](c)
        }


        /**
         * Convert to an instance of the desired type
         * Convert to
         *
         * @param c1
         * @param c2
         * @param b
         * @tparam B
         * @return
         */
        def convertTo[B <: Currency](implicit c1: CurrencyOps[A], c2: CurrencyOps[B], b: Rates): B = {
            c2(c1.to[B](c))
        }
    }

    /**
     * Operations on currency
     *
     * @param a
     */
    implicit class GenericOps(val a: Currency) extends AnyVal {
        def convertGenericTo[T <: Currency : CurrencyOps](implicit b: Rates): Value = convertGeneric[T](a)
    }
}