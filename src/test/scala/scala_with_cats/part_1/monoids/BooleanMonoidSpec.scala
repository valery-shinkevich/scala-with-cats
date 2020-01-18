package scala_with_cats.part_1.monoids

import scala_with_cats.UnitSpec

class BooleanMonoidSpec extends UnitSpec {

  behavior.of("BooleanMonoidSpec")

  it should "orBooleanMonoid" in {
    import scala_with_cats.part_1.monoids.BooleanMonoid.orBooleanMonoid.combine
    combine(false, false) should be(false)
    combine(true, false) should be(true)
    combine(false, true) should be(true)
    combine(true, true) should be(true)
  }

  it should "orBooleanMonoid is lawful" in {
    import scala_with_cats.part_1.monoids.BooleanMonoid.orBooleanMonoid
    checkLaws
  }

  it should "andBooleanMonoid" in {
    import scala_with_cats.part_1.monoids.BooleanMonoid.andBooleanMonoid.combine
    combine(false, false) should be(false)
    combine(true, false) should be(false)
    combine(false, true) should be(false)
    combine(true, true) should be(true)
  }

  it should "andBooleanMonoid is lawful" in {
    import scala_with_cats.part_1.monoids.BooleanMonoid.andBooleanMonoid
    checkLaws
  }

  it should "xnorBooleanMonoid" in {
    import scala_with_cats.part_1.monoids.BooleanMonoid.xnorBooleanMonoid.combine
    combine(false, false) should be(true)
    combine(true, false) should be(false)
    combine(false, true) should be(false)
    combine(true, true) should be(true)
  }

  it should "xnorBooleanMonoid is lawful" in {
    import scala_with_cats.part_1.monoids.BooleanMonoid.xnorBooleanMonoid
    checkLaws
  }

  it should "xorBooleanMonoid" in {
    import scala_with_cats.part_1.monoids.BooleanMonoid.xorBooleanMonoid.combine
    combine(false, false) should be(false)
    combine(true, false) should be(true)
    combine(false, true) should be(true)
    combine(true, true) should be(false)
  }

  it should "xorBooleanMonoid is lawful" in {
    import scala_with_cats.part_1.monoids.BooleanMonoid.xorBooleanMonoid
    checkLaws
  }

  def checkLaws(implicit m: Monoid[Boolean]): Unit = {
    Monoid.associativeLaw(false, false, false) should be(true)
    Monoid.associativeLaw(true, false, false) should be(true)
    Monoid.associativeLaw(false, true, false) should be(true)
    Monoid.associativeLaw(false, false, true) should be(true)
    Monoid.associativeLaw(true, true, false) should be(true)
    Monoid.associativeLaw(false, true, true) should be(true)
    Monoid.associativeLaw(true, false, true) should be(true)
    Monoid.associativeLaw(true, true, true) should be(true)

    Monoid.identityLaw(true) should be(true)
    Monoid.identityLaw(false) should be(true)
  }

}
