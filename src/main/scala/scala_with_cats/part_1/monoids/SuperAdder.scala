package scala_with_cats.part_1.monoids

import cats.Monoid
import cats.syntax.semigroup._

object SuperAdder {

  def add[A: Monoid](items: List[A]): A = items.foldLeft(Monoid[A].empty)(_ |+| _)

  case class Order(totalCost: Double, quantity: Double)

  object Order {

    implicit val order: Monoid[Order] = new Monoid[Order] {
      override def empty: Order                       = Order(0, 0)
      override def combine(x: Order, y: Order): Order = Order(x.totalCost + y.totalCost, x.quantity + y.quantity)
    }
  }
}
