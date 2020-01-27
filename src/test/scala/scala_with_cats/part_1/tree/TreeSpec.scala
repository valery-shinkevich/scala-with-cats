package scala_with_cats.part_1.tree

import cats.syntax.functor._
import scala_with_cats.UnitSpec

class TreeSpec extends UnitSpec {

  behavior.of("TreeSpec")

  it should "treeFunctor" in {
    val tree: Tree[Int] = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    tree.map(_ + 1) should be(Branch(Branch(Leaf(2), Leaf(3)), Leaf(4)))
  }

}
