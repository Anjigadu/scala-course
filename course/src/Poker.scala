object Culoare extends Enumeration {
  //final static
  val PICA, CARO, INIMA, TREFLA = Value

  def apply(s :String) = s match {
    case "C" => CARO
    case "P" => PICA
    case "T" => TREFLA
    case "I" => INIMA
    case _ => throw new IllegalArgumentException
  }
}

//case class Carte

//val VALID_VALUES = List("2","3","4","5","6","7","8","9","10","J","Q","K","A") // ordonate crescator va valoare
//JP JC  1 2 3    vs   JT JI
object Poker extends App {

//  if (Mana("JP","JC","2P","3C","6I") > Mana("JT","JI","2T","3I","8C")) {
//    println("player2 castiga")
//  }
}
