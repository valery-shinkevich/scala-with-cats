package scala_with_cats.part_1.printable

object PrintableInstances {

  implicit val stringPrintable: Printable[String] = (value: String) => value
  implicit val intPrintable: Printable[Int]       = (value: Int) => value.toString

  implicit val catPrintable: Printable[Cat] = (value: Cat) => {
    val name  = Printable.format(value.name)
    val age   = Printable.format(value.age)
    val color = Printable.format(value.color)
    s"$name is a $age year-old $color cat."
  }
}
