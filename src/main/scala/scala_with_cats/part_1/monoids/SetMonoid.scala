package scala_with_cats.part_1.monoids

object SetMonoid {

  implicit def setIntersectionSemigroup[A]: Semigroup[Set[A]] = (x: Set[A], y: Set[A]) => x.intersect(y)

  implicit def setUnionMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
    override def empty: Set[A]                         = Set.empty[A]
    override def combine(x: Set[A], y: Set[A]): Set[A] = x.union(y)
  }

  implicit def setSymmetricDiffMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
    override def empty: Set[A]                         = Set.empty[A]
    override def combine(x: Set[A], y: Set[A]): Set[A] = (x.diff(y)).union(y.diff(x))
  }

}
