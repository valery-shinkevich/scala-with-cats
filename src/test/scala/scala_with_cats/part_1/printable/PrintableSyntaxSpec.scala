package scala_with_cats.part_1.printable

import scala_with_cats.UnitSpec
import PrintableSyntax._
import PrintableInstances._

class PrintableSyntaxSpec extends UnitSpec {

  behavior.of("PrintableSyntaxSpec")

  it should "PrintableOps" in {
    val cat = Cat("Murzik", 7, "gray")
    cat.format should be("Murzik is a 7 year-old gray cat.")
  }

}
