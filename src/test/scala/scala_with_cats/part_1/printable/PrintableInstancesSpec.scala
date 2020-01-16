package scala_with_cats.part_1.printable

import scala_with_cats.UnitSpec

import PrintableInstances._

class PrintableInstancesSpec extends UnitSpec {

  behavior.of("PrintableInstancesSpec")

  it should "stringPrintable" in {
    Printable.format("I printable") should be("I printable")
  }

  it should "intPrintable" in {
    Printable.format(12345) should be("12345")
  }

  it should "catPrintable" in {

    val cat = Cat("Barsik", 5, "black")

    Printable.format(cat) should be("Barsik is a 5 year-old black cat.")
  }
}
