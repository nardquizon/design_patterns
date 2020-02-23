package ph.nard.designpatterns.creational.builder

import ph.nard.designpatterns.creational.builder.Pizza.PizzaDough

/**
  * Builders lets you construct complex objects step by step.
  * The pattern allows you to produce different types and representations of an object using the same construction code.
  */
case class Pizza(dough: PizzaDough,
                 cheeses: List[String] = Nil,
                 sauces: List[String] = Nil,
                 toppings: List[String] = Nil) {
  def cook(): Unit = {
    println(s"Cooking pizza: $this")
  }
}

object Pizza {

  def newBuilder = PizzaBuilder()

  private[Pizza] case class PizzaBuilder() {
    // Use builders when operating on mutable Lists
    // It's bad practice to use append elements on immutable lists since it will create new a instance of list
    private val toppings = List.newBuilder[String]
    private val cheeses = List.newBuilder[String]
    private val sauces = List.newBuilder[String]
    private var dough: PizzaDough = _

    def addDough(dough: PizzaDough): PizzaBuilder = {
      this.dough = dough

      this
    }

    // Use var-args
    def addToppings(toppings: String*): PizzaBuilder = {
      this.toppings ++= toppings

      this
    }

    // Use var-args
    def addCheeses(cheeses: String*): PizzaBuilder = {
      this.cheeses ++= cheeses

      this
    }

    // Use var-args
    def addSauces(sauces: String*): PizzaBuilder = {
      this.sauces ++= sauces

      this
    }

    // Returns the actual pizza object
    def build(): Pizza = {
      Option(dough) match {
        case Some(_) =>
          Pizza(dough, cheeses.result(), sauces.result(), toppings.result())
        case None => throw new InvalidDoughException("Pizza must have dough.")
      }

    }
  }

  sealed trait PizzaDough

  case object ThinCrust extends PizzaDough

  case object FlatBread extends PizzaDough

  case object NeapolitanCrust extends PizzaDough

  case object SicilianStyle extends PizzaDough

  case class InvalidDoughException(message: String) extends Exception(message: String)

  def main(args: Array[String]): Unit = {
    // Cooking pizza: Pizza(ThinCrust,List(),List(),List())
    val emptyPizza = Pizza.newBuilder.addDough(ThinCrust).build()
    emptyPizza.cook()

    // Create Hawaiian Pizza
    val hawaiianPizza =
      newBuilder
        .addDough(ThinCrust)
        .addSauces("tomato sauce")
        .addCheeses("mozzarella cheese")
        .addToppings("pineapples", "bacon", "ham")
        .build()

    // Cooking pizza: Pizza(ThinCrust,List(mozarella),List(tomato sauce),List(pineapples, bacon, ham))
    hawaiianPizza.cook()
  }
}
