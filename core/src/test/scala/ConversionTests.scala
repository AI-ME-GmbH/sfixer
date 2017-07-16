import common.ConversionTestBase
import org.scalatest.prop.PropertyChecks
import sfixer.models._

class ConversionTests extends ConversionTestBase with PropertyChecks {

  "Currencies" should "Return the same value to and from" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[AUD]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from AUD" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[AUD]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from BGN" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[BGN]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from BRL" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[BRL]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from CAD" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[CAD]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from CHF" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[CHF]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from CNY" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[CNY]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from CZK" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[CZK]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from DKK" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[DKK]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from GBP" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[GBP]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from HKD" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[HKD]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from HRK" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[HRK]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from HUF" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[HUF]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from IDR" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[IDR]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from ILS" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[ILS]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from INR" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[INR]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from JPY" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[JPY]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from KRW" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[KRW]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from MXN" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[MXN]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from MYR" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[MYR]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from NOK" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[NOK]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from NZD" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[NZD]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from PHP" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[PHP]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from PLN" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[PLN]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from RON" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[RON]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from RUB" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[RUB]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from SEK" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[SEK]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from SGD" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[SGD]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from THB" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[THB]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from TRY" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[TRY]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from USD" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[USD]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }

  it should "Return the same to and from ZAR" in {
    forAll {
      (a: Currency) =>
        val base = a.genericToWrapped[USD]
        val converted = base.convertTo[ZAR]
        val backTo = converted.convertTo[USD]
        tolerance(base, backTo)
    }
  }
}
