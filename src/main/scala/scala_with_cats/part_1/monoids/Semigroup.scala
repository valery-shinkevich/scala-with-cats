package scala_with_cats.part_1.monoids

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

object Semigroup {

  def associativeLaw[A](x: A, y: A, z: A)(implicit m: Semigroup[A]): Boolean =
    m.combine(x, m.combine(y, z)) == m.combine(m.combine(x, y), z)

}
