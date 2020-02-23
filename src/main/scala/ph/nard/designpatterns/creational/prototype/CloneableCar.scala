package ph.nard.designpatterns.creational.prototype

/**
  * Lets you copy existing objects without making your code dependent on their classes.
  * Approach #2 via Cloneable interface
  */
class CloneableCar(color: String, doors: Int, fuelType: String, wheelCount: Int)
    extends Cloneable {
  override def clone(): AnyRef = super.clone()

  override def toString: String = {
    s"CloneableCar(color=$color, doors=$doors, fuelType=$fuelType, wheelCount=$wheelCount)"
  }
}

object CloneableCar {
  def main(args: Array[String]): Unit = {
    //
    val car = new CloneableCar("Red", 4, "Gas", 4)
    println(car.clone().toString)
    println(car.clone().toString)
  }
}
