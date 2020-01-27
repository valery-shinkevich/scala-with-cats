package scala_with_cats.part_1.tree

import cats.Functor

sealed trait Tree[+A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
case class Leaf[A](value: A)                        extends Tree[A]

object Tree {

  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {

    override def map[A, B](tree: Tree[A])(f: A => B): Tree[B] =
      tree match {
        case Branch(l, r) => Branch(map(l)(f), map(r)(f))
        case Leaf(v)      => Leaf(f(v))
      }
  }
}
