import common.ConversionTestBase
import org.scalatest.prop.PropertyChecks
import sfixer.models._
import sfixer.dsl._


class DSLTests extends ConversionTestBase with PropertyChecks {

  "Currency Operations" should "perform all fundamental operations properly" in {
    forAll {
      (a: Currency, b: Currency) =>

        (a.genericToWrapped[EUR] + b.genericToWrapped[EUR]) shouldBe EUR(a.genericToValue[EUR] + b.genericToValue[EUR])
        (a.genericToWrapped[EUR] - b.genericToWrapped[EUR]) shouldBe EUR(a.genericToValue[EUR] - b.genericToValue[EUR])
        (a.genericToWrapped[EUR] * b.genericToWrapped[EUR]) shouldBe EUR(a.genericToValue[EUR] * b.genericToValue[EUR])
        if(b.amount > BigDecimal(0))
          (a.genericToWrapped[EUR] / b.genericToWrapped[EUR]) shouldBe EUR(a.genericToValue[EUR] / b.genericToValue[EUR])
    }
  }

  it should "Perform all fundamental ops for Integers" in {
    forAll {
      (a: Int, b: Int) =>
        a.usd + b.usd shouldBe USD(BigDecimal(a) + BigDecimal(b))
        a.usd - b.usd shouldBe USD(BigDecimal(a) - BigDecimal(b))
        if(b != 0)
          a.usd / b.usd shouldBe USD(BigDecimal(a)/BigDecimal(b))
        a.usd * b.usd shouldBe USD(BigDecimal(a)*BigDecimal(b))
    }
  }
}
