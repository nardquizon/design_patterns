package ph.nard.designpatterns.creational.singleton

/**
  * Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.
  */
// Notice how we made the constructor private
class Program private ()

object Program {

  // Lazy evaluation on static program
  private lazy val program: Program = Program()

  // Notice how we made the apply private as well.
  private def apply(): Program = new Program()

  // Declare a public static creation method for getting the singleton instance.
  def getProgram: Program = {
    program
  }
}
