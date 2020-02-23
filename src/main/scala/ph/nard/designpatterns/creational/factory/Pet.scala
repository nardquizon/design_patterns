package ph.nard.designpatterns.creational.factory

import ph.nard.designpatterns.creational.factory.Pet.Species

/**
  * The factory method is used to offer a single interface to instantiate one of the multiple classes.
  * Do NOT expose to the creation logic to the client.
  * Client should always refer to a newly created object with the help of a common interface.
  */
trait Pet {
  def species: Species
  def name: String
}

object Pet {

  // Apply will serve as the factory method.
  def apply(species: Species, name: String): Pet = {
    species match {
      case Cat(_)     => PetCat(species, name)
      case Dog(_)     => PetDog(species, name)
      case Hamster(_) => PetHamster(species, name)
      case Snake(_)   => PetSnake(species, name)
    }
  }

  // Hide these constructors to accessors outside of this class
  // This way, clients will be forced to
  private case class PetCat(species: Species, name: String) extends Pet

  private case class PetDog(species: Species, name: String) extends Pet

  private case class PetHamster(species: Species, name: String) extends Pet

  private case class PetSnake(species: Species, name: String) extends Pet

  // Sealed trait means, the subclasses and the implementations can be defined only in the same source file as the sealed trait or class.
  sealed trait Species {
    def breed: String
  }

  case class Cat(breed: String) extends Species

  case class Dog(breed: String) extends Species

  case class Hamster(breed: String) extends Species

  case class Snake(breed: String) extends Species
}
