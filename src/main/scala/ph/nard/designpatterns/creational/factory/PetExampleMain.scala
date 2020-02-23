package ph.nard.designpatterns.creational.factory

import ph.nard.designpatterns.creational.factory.Pet.{Cat, Dog}

object PetExampleMain {

  def main(args: Array[String]): Unit = {
    // Get a cat
    val cat = Pet(Cat("Siamese"), "Meowsy")
    println(cat)

    // Get a dog
    val dog = Pet(Dog("Chow-Chow"), "Bantay")
    println(dog)
  }
}
