package scala_with_cats.part_1.printable

trait Printable[A] {
  def format(value: A): String
}

object Printable {
  def format[A](value: A)(implicit pr: Printable[A]): String = pr.format(value)
  def print[A](value: A)(implicit pr: Printable[A]): Unit    = println(format(value))
}
