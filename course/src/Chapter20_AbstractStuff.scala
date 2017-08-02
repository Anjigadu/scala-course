
trait Abstract{
  def metoda:Int   // -- fix "abstract int metoda()" din Java
  val valoare:Int // "abstract int valoare()"

//  var variab:Int = 0 // "abstract int valoare()" si "abstract void valoare_=(int newVal)"

  private[this] var variabX:Int = 0
  def variab:Int = variabX
  def variab_=(newVal:Int) = variabX = newVal

  class XYZ {
    println(variabX)
  }
}


object Chapter20_AbstractStuff extends App {

}
