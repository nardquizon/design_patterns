package ph.nard.designpatterns.creational.abstractfactory

/**
  * Lets you produce families of related objects without specifying their concrete classes.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val osxFactory = GUIFactory.createOsSpecificFactory("OSX")
    println(osxFactory.createButton.paint)
    println(osxFactory.createCheckBox.paint)

    val linuxFactory = GUIFactory.createOsSpecificFactory("Linux")
    println(linuxFactory.createButton.paint)
    println(linuxFactory.createCheckBox.paint)

    // Output
    // Display OSX Button
    // Display OSX CheckBox
    // Display Linux Button
    // Display Linux CheckBox
  }
}
