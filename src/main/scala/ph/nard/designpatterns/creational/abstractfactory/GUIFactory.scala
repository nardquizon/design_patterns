package ph.nard.designpatterns.creational.abstractfactory

import Button._
import CheckBox._

sealed trait GUIFactory {
  def createButton: Button
  def createCheckBox: CheckBox
}

object GUIFactory {

  class WindowsFactory extends GUIFactory {
    def createButton: Button = WindowsButton
    def createCheckBox: CheckBox = WindowsCheckBox
  }

  class OSXFactory extends GUIFactory {
    def createButton: Button = OSXButton
    def createCheckBox: CheckBox = OSXCheckBox
  }

  class LinuxFactory extends GUIFactory {
    def createButton: Button = LinuxButton
    def createCheckBox: CheckBox = LinuxCheckBox
  }

  def createOsSpecificFactory(osType: String): GUIFactory = {
    osType match {
      case "Windows" => new WindowsFactory
      case "OSX"     => new OSXFactory
      case "Linux"   => new LinuxFactory
      case x         => throw new IllegalArgumentException(s"Unrecognized OS Type: $x.")
    }
  }
}
