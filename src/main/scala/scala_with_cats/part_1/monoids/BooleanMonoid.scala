package scala_with_cats.part_1.monoids

object BooleanMonoid {

  implicit val andBooleanMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean                           = true
    override def combine(x: Boolean, y: Boolean): Boolean = x && y
  }

  implicit val orBooleanMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean                           = false
    override def combine(x: Boolean, y: Boolean): Boolean = x || y
  }

  implicit val xnorBooleanMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean                           = true
    override def combine(x: Boolean, y: Boolean): Boolean = (x || !y) && (!x || y)
  }

  implicit val xorBooleanMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean                           = false
    override def combine(x: Boolean, y: Boolean): Boolean = (x && !y) || (!x && y)
  }

}
