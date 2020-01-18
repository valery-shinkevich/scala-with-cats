package scala_with_cats.part_1.eq

import scala_with_cats.UnitSpec
import scala_with_cats.part_1.printable.Cat

class CatEqSpec extends UnitSpec {

  behavior of "CatEqSpec"

  it should "eq" in {

    val cat1 = Cat("Barsik", 11, "red")
    val cat2 = Cat("Barsik", 11, "red")

    cat1 === cat2 should be (true)
  }

  it should "not eq" in {

    val cat1 = Cat("Barsik", 11, "red")
    val cat2 = Cat("Barsik", 11, "black")

    cat1 === cat2 should be (false)
  }

  it should "eq with option" in {

    val cat1 = Option(Cat("Barsik", 11, "black"))
    val cat2 = Option(Cat("Barsik", 11, "black"))

    cat1 === cat2 should be (true)
  }

  it should "not eq with option" in {

    val cat1 = Option(Cat("Barsik", 11, "red"))
    val cat2 = Option(Cat("Barsik", 11, "black"))

    cat1 === cat2 should be (false)
  }


  it should "not eq with some cat and none" in {

    val cat1 = Some(Cat("Barsik", 11, "red"))
    val cat2 = Option.empty[Cat]

    cat1 === cat2 should be (false)
  }

}
