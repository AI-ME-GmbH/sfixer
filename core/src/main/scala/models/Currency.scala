package models

import scala.reflect.ClassTag

/**
 * Our currency implementations
 *
 */
sealed trait Currency {
    def amount: Value
}

abstract class DeriveTypeClass[T <: Currency](implicit classTag: ClassTag[T]){
    val prefix: String = classTag.runtimeClass.getSimpleName
    implicit val converter: Ops[T] = Ops[T](prefix)
}

final case class EUR(amount: Value) extends Currency

object EUR extends DeriveTypeClass[EUR]

final case class AUD(amount: Value) extends Currency

object AUD extends DeriveTypeClass[AUD]

final case class USD(amount: Value) extends Currency

object USD extends DeriveTypeClass[USD]

final case class CAD(amount: Value) extends Currency

object CAD extends DeriveTypeClass[CAD]

final case class BGN (amount: Value) extends Currency

object BGN extends DeriveTypeClass[BGN]


final case class BRL (amount: Value) extends Currency

object BRL extends DeriveTypeClass[BRL]


final case class CHF (amount: Value) extends Currency

object CHF extends DeriveTypeClass[CHF]


final case class CNY (amount: Value) extends Currency

object CNY extends DeriveTypeClass[CNY]


final case class CZK (amount: Value) extends Currency

object CZK extends DeriveTypeClass[CZK]


final case class DKK (amount: Value) extends Currency

object DKK extends DeriveTypeClass[DKK]


final case class GBP (amount: Value) extends Currency

object GBP extends DeriveTypeClass[GBP]


final case class HKD (amount: Value) extends Currency

object HKD extends DeriveTypeClass[HKD]


final case class HRK (amount: Value) extends Currency

object HRK extends DeriveTypeClass[HRK]


final case class HUF (amount: Value) extends Currency

object HUF extends DeriveTypeClass[HUF]


final case class IDR (amount: Value) extends Currency

object IDR extends DeriveTypeClass[IDR]


final case class ILS (amount: Value) extends Currency

object ILS extends DeriveTypeClass[ILS]


final case class INR (amount: Value) extends Currency

object INR extends DeriveTypeClass[INR]


final case class JPY (amount: Value) extends Currency

object JPY extends DeriveTypeClass[JPY]


final case class KRW (amount: Value) extends Currency

object KRW extends DeriveTypeClass[KRW]


final case class MXN (amount: Value) extends Currency

object MXN extends DeriveTypeClass[MXN]


final case class MYR (amount: Value) extends Currency

object MYR extends DeriveTypeClass[MYR]


final case class NOK (amount: Value) extends Currency

object NOK extends DeriveTypeClass[NOK]


final case class NZD (amount: Value) extends Currency

object NZD extends DeriveTypeClass[NZD]


final case class PHP (amount: Value) extends Currency

object PHP extends DeriveTypeClass[PHP]


final case class PLN (amount: Value) extends Currency

object PLN extends DeriveTypeClass[PLN]


final case class RON (amount: Value) extends Currency

object RON extends DeriveTypeClass[RON]


final case class RUB (amount: Value) extends Currency

object RUB extends DeriveTypeClass[RUB]


final case class SEK (amount: Value) extends Currency

object SEK extends DeriveTypeClass[SEK]


final case class SGD (amount: Value) extends Currency

object SGD extends DeriveTypeClass[SGD]


final case class THB (amount: Value) extends Currency

object THB extends DeriveTypeClass[THB]


final case class TRY (amount: Value) extends Currency

object TRY extends DeriveTypeClass[TRY]

final case class ZAR (amount: Value) extends Currency

object ZAR extends DeriveTypeClass[ZAR]



object Currency {


    def deriveConverter[T <: Currency](ident: String): CurrencyOps[T] = Ops[T](ident)

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
    private [this] def convertGeneric[Target <: Currency : CurrencyOps](a: Currency)(implicit b: BaseValue): Value = a match {
        case c: EUR => c.convertTo[Target]
        case c: AUD => c.convertTo[Target]
        case c: BGN => c.convertTo[Target]
        case c: BRL => c.convertTo[Target]
        case c: CAD => c.convertTo[Target]
        case c: CHF => c.convertTo[Target]
        case c: CNY => c.convertTo[Target]
        case c: CZK => c.convertTo[Target]
        case c: DKK => c.convertTo[Target]
        case c: GBP => c.convertTo[Target]
        case c: HKD => c.convertTo[Target]
        case c: HRK => c.convertTo[Target]
        case c: HUF => c.convertTo[Target]
        case c: IDR => c.convertTo[Target]
        case c: ILS => c.convertTo[Target]
        case c: INR => c.convertTo[Target]
        case c: JPY => c.convertTo[Target]
        case c: KRW => c.convertTo[Target]
        case c: MXN => c.convertTo[Target]
        case c: MYR => c.convertTo[Target]
        case c: NOK => c.convertTo[Target]
        case c: NZD => c.convertTo[Target]
        case c: PHP => c.convertTo[Target]
        case c: PLN => c.convertTo[Target]
        case c: RON => c.convertTo[Target]
        case c: RUB => c.convertTo[Target]
        case c: SEK => c.convertTo[Target]
        case c: SGD => c.convertTo[Target]
        case c: THB => c.convertTo[Target]
        case c: TRY => c.convertTo[Target]
        case c: USD => c.convertTo[Target]
        case c: ZAR => c.convertTo[Target]
    }

    /**
     * Operations on currency
     *
     * @param c
     * @tparam A
     */
    implicit class ConverterOps[A <: Currency](val c: A) extends AnyVal{
        def convertTo[B <: Currency](implicit c1: CurrencyOps[A], c2: CurrencyOps[B], b: BaseValue): Value = {
            c1.to[B](c)
        }
    }

    /**
     * Operations on currency
     *
     * @param a
     */
    implicit class GenericOps(val a: Currency) extends AnyVal {
        def convertGenericTo[T <: Currency : CurrencyOps](implicit b: BaseValue): Value = convertGeneric[T](a)
    }
}