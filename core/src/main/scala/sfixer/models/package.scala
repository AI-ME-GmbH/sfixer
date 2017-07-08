package sfixer

package object models {
  type CurrencyValue = BigDecimal

  val ROUNDING_MODE = BigDecimal.RoundingMode.HALF_UP
  val SCALE = 8
}
