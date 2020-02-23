package ph.nard.designpatterns.creational.singleton

/**
  * Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.
  */
object Main {
  def main(args: Array[String]): Unit = {
    // Prints true
    println(Program.getProgram == Program.getProgram)

    // Compiler Error
    // new Program()

    // Compiler Error
    // Program()
  }
}
