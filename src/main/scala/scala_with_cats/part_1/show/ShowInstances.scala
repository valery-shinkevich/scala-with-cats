package scala_with_cats.part_1.show

import cats._
import cats.implicits._
import scala_with_cats.part_1.printable.Cat

object ShowInstances {

  implicit val catShow: Show[Cat] = (value: Cat) => {
    val name  = value.name.show
    val age   = value.age.show
    val color = value.color.show
    s"$name is a $age year-old $color cat."
  }
}

object ShowSyntax {

  implicit class showOps[A](value: A) {
    def show(implicit pr: Show[A]): String = pr.show(value)
    def print(implicit pr: Show[A]): Unit  = Console.println(show)
  }

}
