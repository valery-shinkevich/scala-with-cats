package scala_with_cats.part_1.eq

import cats.Eq
import cats.syntax.eq._
import scala_with_cats.part_1.printable.Cat

object CatEq {
  import cats.instances.int._
  import cats.instances.string._

  implicit val catEq: Eq[Cat] = Eq.instance { (cat1, cat2) =>
    (cat1.name === cat2.name) && (cat1.age === cat2.age) && (cat1.color === cat2.color)
  }

}
