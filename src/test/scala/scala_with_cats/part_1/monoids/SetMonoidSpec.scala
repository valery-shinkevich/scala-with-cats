package scala_with_cats.part_1.monoids

import scala_with_cats.UnitSpec

class SetMonoidSpec extends UnitSpec {

  behavior.of("SetMonoidSpec")

  it should "setIntersectionSemigroup" in {
    import scala_with_cats.part_1.monoids.SetMonoid.setIntersectionSemigroup

    val set1 = Set(1, 2, 3, 4, 5)
    val set2 = Set(2, 4)

    setIntersectionSemigroup.combine(set1, set2) should be(Set(2, 4))
  }

  it should "setSymmetricDiffMonoid" in {
    import scala_with_cats.part_1.monoids.SetMonoid.setSymmetricDiffMonoid

    val set1 = Set(1, 2, 3, 4, 5)
    val set2 = Set(2, 4)

    setSymmetricDiffMonoid.combine(set1, set2) should be(Set(1, 3, 5))
  }

  it should "setUnionMonoid" in {
    import scala_with_cats.part_1.monoids.SetMonoid.setUnionMonoid

    val set1 = Set(1, 2, 3, 4, 5)
    val set2 = Set(0, 2, 4, 6, 7)

    setUnionMonoid.combine(set1, set2) should be(Set(0, 1, 2, 3, 4, 5, 6, 7))
  }

  it should "setIntersectionSemigroup is lawful" in {

    import scala_with_cats.part_1.monoids.SetMonoid.setIntersectionSemigroup

    val set1 = Set(1, 2)
    val set2 = Set(2, 4)
    val set3 = Set(3, 4, 5)

    Semigroup.associativeLaw(set1, set2, set3) should be(true)
  }

  it should "setSymmetricDiffMonoid is lawful" in {
    import scala_with_cats.part_1.monoids.SetMonoid.setSymmetricDiffMonoid

    val set1 = Set(1, 2)
    val set2 = Set(2, 4)
    val set3 = Set(3, 4, 5)

    Monoid.associativeLaw(set1, set2, set3) should be(true)
    Monoid.identityLaw(set1) should be(true)
  }

  it should "setUnionMonoid is lawful" in {
    import scala_with_cats.part_1.monoids.SetMonoid.setUnionMonoid

    val set1 = Set(1, 2)
    val set2 = Set(2, 4)
    val set3 = Set(3, 4, 5)

    Monoid.associativeLaw(set1, set2, set3) should be(true)
    Monoid.identityLaw(set1) should be(true)
  }

}
