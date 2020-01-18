package scala_with_cats.part_1.monoids

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Monoid {
  def apply[A](implicit ma: Monoid[A]): Monoid[A] = ma

  def associativeLaw[A](x: A, y: A, z: A)(implicit m: Monoid[A]): Boolean =
    m.combine(x, m.combine(y, z)) == m.combine(m.combine(x, y), z)

  def identityLaw[A](x: A)(implicit m: Monoid[A]): Boolean = (m.combine(x, m.empty) == x) && (m.combine(m.empty, x) == x)
}
