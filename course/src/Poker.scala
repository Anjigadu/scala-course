
object Culoare extends Enumeration {
  // ordonate crescator ca valoare
  val PICA = Value("p")
  val CARO = Value("c")
  val INIMA = Value("i")
  val TREFLA = Value("t")

  def apply(s :String) = s match {
    case "C" => CARO
    case "P" => PICA
    case "T" => TREFLA
    case "I" => INIMA
    case _ => throw new IllegalArgumentException
  }
}

//val VALID_VALUES = List("1","2","3","4","5","6","7","8","9","10","J","Q","K","A") // ordonate crescator va valoare

object Poker {

}
