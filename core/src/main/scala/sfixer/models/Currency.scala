package sfixer.models

import scala.reflect.ClassTag

/**
 * Our currency implementations
 *
 */
sealed trait Currency {
  def amount: CurrencyValue
}

/**
 * Our converting type class
 *
 * @tparam T
 */
sealed trait CurrencyOps[T <: Currency]{
  def identifier: String

  /**
   * Convert a currency A into a currency B
   *
   * @param currencyA Source
   * @param ops Currency operations
   * @param rates Rates impl
   * @tparam B Instance of currency to convert to
   * @return
   */
  def to[B <: Currency](currencyA: T)(implicit ops: CurrencyOps[B], rates: Rates): CurrencyValue =
    (currencyA.amount * rates.rate[B]) / rates.rate[T](this)

  /**
   * Convert a currency A into a currency B, with explicit rate
   *
   * @param currencyA Source
   * @param ops Currency operations
   * @param rates Rates impl
   * @tparam B Instance of currency to convert to
   * @return
   */
  def to[B <: Currency](currencyA: T, rates: Rates)(implicit ops: CurrencyOps[B]): CurrencyValue =
    (currencyA.amount * rates.rate[B]) / rates.rate[T](this)
  def apply(amount: CurrencyValue): T
}

/**
 * Get the simple class name generically.
 *
 * @param classTag
 * @tparam T
 */
abstract class DerivePrefix[T <: Currency](implicit classTag: ClassTag[T]){
  val prefix: String = classTag.runtimeClass.getSimpleName
}

final case class EUR(amount: CurrencyValue) extends Currency

object EUR extends DerivePrefix[EUR] {

  implicit val converter: CurrencyOps[EUR] = new CurrencyOps[EUR] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): EUR = EUR(amount)
  }
}

final case class AUD(amount: CurrencyValue) extends Currency

object AUD extends DerivePrefix[AUD] {

  implicit val converter: CurrencyOps[AUD] = new CurrencyOps[AUD] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): AUD = AUD(amount)
  }
}

final case class USD(amount: CurrencyValue) extends Currency

object USD extends DerivePrefix[USD] {

  implicit val converter: CurrencyOps[USD] = new CurrencyOps[USD] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): USD = USD(amount)
  }
}

final case class CAD(amount: CurrencyValue) extends Currency

object CAD extends DerivePrefix[CAD] {

  implicit val converter: CurrencyOps[CAD] = new CurrencyOps[CAD] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): CAD = CAD(amount)
  }
}

final case class BGN (amount: CurrencyValue) extends Currency

object BGN extends DerivePrefix[BGN] {

  implicit val converter: CurrencyOps[BGN] = new CurrencyOps[BGN] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): BGN = BGN(amount)
  }
}

final case class BRL (amount: CurrencyValue) extends Currency

object BRL extends DerivePrefix[BRL] {

  implicit val converter: CurrencyOps[BRL] = new CurrencyOps[BRL] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): BRL = BRL(amount)
  }
}

final case class CHF (amount: CurrencyValue) extends Currency

object CHF extends DerivePrefix[CHF] {

  implicit val converter: CurrencyOps[CHF] = new CurrencyOps[CHF] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): CHF = CHF(amount)
  }
}

final case class CNY (amount: CurrencyValue) extends Currency

object CNY extends DerivePrefix[CNY] {

  implicit val converter: CurrencyOps[CNY] = new CurrencyOps[CNY] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): CNY = CNY(amount)
  }
}

final case class CZK (amount: CurrencyValue) extends Currency

object CZK extends DerivePrefix[CZK] {

  implicit val converter: CurrencyOps[CZK] = new CurrencyOps[CZK] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): CZK = CZK(amount)
  }
}

final case class DKK (amount: CurrencyValue) extends Currency

object DKK extends DerivePrefix[DKK] {

  implicit val converter: CurrencyOps[DKK] = new CurrencyOps[DKK] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): DKK = DKK(amount)
  }
}

final case class GBP (amount: CurrencyValue) extends Currency

object GBP extends DerivePrefix[GBP] {

  implicit val converter: CurrencyOps[GBP] = new CurrencyOps[GBP] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): GBP = GBP(amount)
  }
}

final case class HKD (amount: CurrencyValue) extends Currency

object HKD extends DerivePrefix[HKD] {

  implicit val converter: CurrencyOps[HKD] = new CurrencyOps[HKD] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): HKD = HKD(amount)
  }
}

final case class HRK (amount: CurrencyValue) extends Currency

object HRK extends DerivePrefix[HRK] {

  implicit val converter: CurrencyOps[HRK] = new CurrencyOps[HRK] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): HRK = HRK(amount)
  }
}

final case class HUF (amount: CurrencyValue) extends Currency

object HUF extends DerivePrefix[HUF] {

  implicit val converter: CurrencyOps[HUF] = new CurrencyOps[HUF] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): HUF = HUF(amount)
  }
}

final case class IDR (amount: CurrencyValue) extends Currency

object IDR extends DerivePrefix[IDR] {

  implicit val converter: CurrencyOps[IDR] = new CurrencyOps[IDR] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): IDR = IDR(amount)
  }
}

final case class ILS (amount: CurrencyValue) extends Currency

object ILS extends DerivePrefix[ILS] {

  implicit val converter: CurrencyOps[ILS] = new CurrencyOps[ILS] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): ILS = ILS(amount)
  }
}

final case class INR (amount: CurrencyValue) extends Currency

object INR extends DerivePrefix[INR] {

  implicit val converter: CurrencyOps[INR] = new CurrencyOps[INR] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): INR = INR(amount)
  }
}

final case class JPY (amount: CurrencyValue) extends Currency

object JPY extends DerivePrefix[JPY] {

  implicit val converter: CurrencyOps[JPY] = new CurrencyOps[JPY] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): JPY = JPY(amount)
  }
}

final case class KRW (amount: CurrencyValue) extends Currency

object KRW extends DerivePrefix[KRW] {

  implicit val converter: CurrencyOps[KRW] = new CurrencyOps[KRW] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): KRW = KRW(amount)
  }
}

final case class MXN (amount: CurrencyValue) extends Currency

object MXN extends DerivePrefix[MXN] {

  implicit val converter: CurrencyOps[MXN] = new CurrencyOps[MXN] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): MXN = MXN(amount)
  }
}

final case class MYR (amount: CurrencyValue) extends Currency

object MYR extends DerivePrefix[MYR] {

  implicit val converter: CurrencyOps[MYR] = new CurrencyOps[MYR] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): MYR = MYR(amount)
  }
}

final case class NOK (amount: CurrencyValue) extends Currency

object NOK extends DerivePrefix[NOK] {

  implicit val converter: CurrencyOps[NOK] = new CurrencyOps[NOK] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): NOK = NOK(amount)
  }
}

final case class NZD (amount: CurrencyValue) extends Currency

object NZD extends DerivePrefix[NZD] {

  implicit val converter: CurrencyOps[NZD] = new CurrencyOps[NZD] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): NZD = NZD(amount)
  }
}

final case class PHP (amount: CurrencyValue) extends Currency

object PHP extends DerivePrefix[PHP] {

  implicit val converter: CurrencyOps[PHP] = new CurrencyOps[PHP] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): PHP = PHP(amount)
  }
}

final case class PLN (amount: CurrencyValue) extends Currency

object PLN extends DerivePrefix[PLN] {

  implicit val converter: CurrencyOps[PLN] = new CurrencyOps[PLN] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): PLN = PLN(amount)
  }
}

final case class RON (amount: CurrencyValue) extends Currency

object RON extends DerivePrefix[RON] {

  implicit val converter: CurrencyOps[RON] = new CurrencyOps[RON] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): RON = RON(amount)
  }
}

final case class RUB (amount: CurrencyValue) extends Currency

object RUB extends DerivePrefix[RUB] {

  implicit val converter: CurrencyOps[RUB] = new CurrencyOps[RUB] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): RUB = RUB(amount)
  }
}

final case class SEK (amount: CurrencyValue) extends Currency

object SEK extends DerivePrefix[SEK] {

  implicit val converter: CurrencyOps[SEK] = new CurrencyOps[SEK] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): SEK = SEK(amount)
  }
}

final case class SGD (amount: CurrencyValue) extends Currency

object SGD extends DerivePrefix[SGD] {

  implicit val converter: CurrencyOps[SGD] = new CurrencyOps[SGD] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): SGD = SGD(amount)
  }
}

final case class THB (amount: CurrencyValue) extends Currency

object THB extends DerivePrefix[THB] {

  implicit val converter: CurrencyOps[THB] = new CurrencyOps[THB] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): THB = THB(amount)
  }
}

final case class TRY (amount: CurrencyValue) extends Currency

object TRY extends DerivePrefix[TRY] {

  implicit val converter: CurrencyOps[TRY] = new CurrencyOps[TRY] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): TRY = TRY(amount)
  }
}

final case class ZAR (amount: CurrencyValue) extends Currency

object ZAR extends DerivePrefix[ZAR] {

  implicit val converter: CurrencyOps[ZAR] = new CurrencyOps[ZAR] {

    val identifier: String = prefix

    def apply(amount: CurrencyValue): ZAR = ZAR(amount)
  }
}



object Currency {



  /**
   * Smash two pieces of information to retrieve a currency value
   *
   * @param identifier
   * @param value
   * @return
   */
  def smash(identifier: String)(value: CurrencyValue): Currency = {
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
   * Smash, on a tuple
   *
   * @param identifierTuple
   * @return
   */
  def smash(identifierTuple: (String, CurrencyValue)): Currency = {
    smash(identifierTuple._1)(identifierTuple._2)
  }

  /**
   * Generic conversions
   *
   * @param a
   * @param b
   * @tparam Target
   * @return
   */
  private [this] def convertGeneric[Target <: Currency : CurrencyOps](a: Currency)(implicit b: Rates): CurrencyValue = a match {
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
  implicit class ConverterOps[A <: Currency : CurrencyOps](val c: A)(implicit c1: CurrencyOps[A]) {

    /**
     * Convert to unwrapped
     *
     * @param r
     * @tparam B
     * @return
     */
    def convertToValue[B <: Currency : CurrencyOps](implicit r: Rates): CurrencyValue = {
      c1.to[B](c).setScale(SCALE, ROUNDING_MODE)
    }

    /**
     * Convert to unwrapped, using explicit rate
     *
     * @param r
     * @tparam B
     * @return
     */
    def convertToValue[B <: Currency : CurrencyOps](r: Rates): CurrencyValue = {
      c1.to[B](c,r).setScale(SCALE, ROUNDING_MODE)
    }

    /**
     * Convert to an instance of the desired type
     *
     * @param b
     * @tparam B
     * @return
     */
    def convertTo[B <: Currency : CurrencyOps](implicit b: Rates): B = {
      val c2 = implicitly[CurrencyOps[B]]
      c2(c1.to[B](c).setScale(SCALE, ROUNDING_MODE))
    }

    /**
     * Convert to an instance of the desired type
     *
     * @param b
     * @tparam B
     * @return
     */
    def convertTo[B <: Currency : CurrencyOps](b: Rates): B = {
      val c2 = implicitly[CurrencyOps[B]]
      c2(c1.to[B](c,b).setScale(SCALE, ROUNDING_MODE))
    }
  }

  /**
   * Operations on currency
   *
   * @param a
   */
  implicit class GenericOps(val a: Currency) extends AnyVal {
    /**
     * return the converted value
     *
     * @param b
     * @tparam T
     * @return
     */
    def convertGenericToValue[T <: Currency : CurrencyOps](implicit b: Rates): CurrencyValue = convertGeneric[T](a)

    /**
     * return the converted value
     *
     * @param b
     * @tparam T
     * @return
     */
    def convertGenericToValue[T <: Currency : CurrencyOps](b: Rates): CurrencyValue = {
      implicit val __r = b
      convertGeneric[T](a)
    }

    /**
     * Return a wrapped T for a generic instance
     *
     * @param b
     * @tparam T
     * @return
     */
    def convertGenericToWrapped[T <: Currency : CurrencyOps](implicit b: Rates): T = {
      val ops = implicitly[CurrencyOps[T]]
      ops(convertGeneric[T](a))
    }

    /**
     * Return a wrapped T for a generic instance
     *
     * @param b
     * @tparam T
     * @return
     */
    def convertGenericToWrapped[T <: Currency : CurrencyOps](b: Rates): T = {
      implicit val __r = b
      val ops = implicitly[CurrencyOps[T]]
      ops(convertGeneric[T](a))
    }

  }
}