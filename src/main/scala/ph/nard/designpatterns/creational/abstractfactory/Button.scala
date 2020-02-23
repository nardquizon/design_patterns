package ph.nard.designpatterns.creational.abstractfactory

sealed trait Button {
  def paint: String
}

object Button {

  case object WindowsButton extends Button {
    def paint: String = "Display Windows Button"
  }

  case object OSXButton extends Button {
    def paint: String = "Display OSX Button"
  }

  case object LinuxButton extends Button {
    def paint: String = "Display Linux Button"
  }
}
