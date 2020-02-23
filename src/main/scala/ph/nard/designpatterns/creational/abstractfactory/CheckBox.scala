package ph.nard.designpatterns.creational.abstractfactory

sealed trait CheckBox {
  def paint: String
}

object CheckBox {
  case object WindowsCheckBox extends CheckBox {
    def paint: String = "Display Windows CheckBox"
  }

  case object OSXCheckBox extends CheckBox {
    def paint: String = "Display OSX CheckBox"
  }

  case object LinuxCheckBox extends CheckBox {
    def paint: String = "Display Linux CheckBox"
  }
}
