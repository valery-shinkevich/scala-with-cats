package scala_with_cats.part_1.show

import scala_with_cats.UnitSpec
import scala_with_cats.part_1.printable.Cat
import scala_with_cats.part_1.show.ShowInstances._
import scala_with_cats.part_1.show.ShowSyntax._

class ShowInstancesSpec extends UnitSpec {

  behavior.of("ShowInstancesSpec")

  it should "catShow" in {

    val cat = Cat("Barsik", 5, "black")

    cat.show should be("Barsik is a 5 year-old black cat.")
  }

}
