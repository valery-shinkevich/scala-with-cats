package scala_with_cats.part_1.monoids

import scala_with_cats.UnitSpec
import scala_with_cats.part_1.monoids.SuperAdder.Order

class SuperAdderSpec extends UnitSpec {

  behavior of "SuperAdderSpec"

  it should "add" in {

    val items  = List(1, 2, 3)

    import cats.instances.int._

    SuperAdder.add(items) should be (6)
  }

  it should "add options" in {

    val items  = List(Option(1), Option(2), Option(3))

    import cats.instances.int._
    import cats.instances.option._
    SuperAdder.add(items) should be (Option(6))
  }


  it should "add orders" in {

    val items  = List(Order(1.5,2.0), Order(2.0, 1.0), Order(3.3, 10))

    SuperAdder.add(items) should be (Order(6.8, 13))
  }

}
