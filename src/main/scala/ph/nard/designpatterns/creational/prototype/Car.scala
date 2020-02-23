package ph.nard.designpatterns.creational.prototype

/**
  * Lets you copy existing objects without making your code dependent on their classes.
  * Approach #1 via Case Class copy (Preferred Way!).
  *
  */
case class Car(color: String, doors: Int, fuelType: String, wheelCount: Int)

object Car {
  def main(args: Array[String]): Unit = {

    val car = Car("Red", 4, "Gas", 4)
    // Copy as is
    println(car.copy())

    // Copy but change color
    println(car.copy(color = "blue"))

    // Copy but change fuelType
    println(car.copy(fuelType = "Diesel"))
  }
}
