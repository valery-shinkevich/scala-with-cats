package scala_with_cats.part_1.printable

object PrintableSyntax {

  implicit class PrintableOps[A](value: A) {
    def format(implicit pr: Printable[A]): String = Printable.format(value)
    def print(implicit pr: Printable[A]): Unit    = Printable.print(value)
  }

}
