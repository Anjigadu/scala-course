import Poker.mana1

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

object Valoare{
  val VALID_VALUES = List("2","3","4","5","6","7","8","9","10","J","Q","K","A") // ordonate crescator va valoare
  implicit def convertFromString(s: String):Valoare = new Valoare(s)
}
case class Valoare private(val index:Int) {
  require(index < Valoare.VALID_VALUES.size && index > -1)
  def this(nr: String) = {
    this(Valoare.VALID_VALUES.indexOf(nr))
  }

  override def toString: String = Valoare.VALID_VALUES(index)
}
case class Carte(valoare:Valoare, culoare:Culoare.Value) extends Ordered[Carte]{
  override def compare(that: Carte): Int = this.valoare.index.compareTo(that.valoare.index)
}
object Carte {
  implicit def convertFromString(s: String): Carte = {
    val valoare = s.substring(0, s.length - 1)
    val culoare = Culoare(s(s.length - 1).toString)
    new Carte(valoare, culoare)
  }
}

case class Mana (carti:Set[Carte]) extends Ordered[Mana]{
  override def compare(that: Mana): Int =
//    if (this.evaluate.compareTo(that.evaluate)!=0) {
      return this.evaluate compareTo that.evaluate
//    } else {
      //compar mainile sortate invers
      // 7 6 4 2 1 ***
      // 7 5 3 2 1
//      this.carti.toList.sorted.reverse.compareTo(that.carti.toList.sorted.reverse)
//    }
// 1) formatia e diferita
  // 2) maximum dintre cartile intrate in formatie
  // 3) maximul din restul de carti

  def evaluate: Formatie =
    if (amOPereche.isDefined) {
      amOPereche.get
    } else Varza(this)

  def amOPereche: Option[OPereche] = {
    val perechiDe2 = carti.groupBy(_.valoare).values.map(set=>set.toList).filter(_.size == 2).toList
    if (perechiDe2.size == 1) {
      val x = perechiDe2.head
      Some(OPereche(x(0), x(1)))
    } else
      None
  }
}

object Mana {
  def apply(carti: Carte*): Mana = new Mana(carti.toSet)
}
abstract class Formatie(val prioritate: Int) extends Ordered[Formatie] {
  override def compare(that: Formatie): Int =
      return this.prioritate compareTo that.prioritate
}
case class Varza(mana: Mana) extends Formatie(1)
case class OPereche(carte1: Carte, carte2: Carte) extends Formatie(2)
//case class DouaPerechi(pereche1: OPereche, pereche2: OPereche) extends Formatie(3)
//case class TreiBucati(carte1: Carte, carte2: Carte, carte3: Carte) extends Formatie(4)
//case class Quinta(mana: Mana) extends Formatie(5)
//case class CuloareMana(mana: Mana) extends Formatie(6)
//case class Full(triplet: TreiBucati, pereche: OPereche) extends Formatie(7)
//case class Careu(carte1: Carte, carte2: Carte, carte3: Carte, carte4: Carte) extends Formatie(8)
//case class QuintaRoiala(mana: Mana) extends Formatie(9)


//JP JC  1 2 3    vs   JT JI
object Poker extends App {

  val mana1 = Mana("JP", "4C", "2P", "2C", "4I")
  val mana2 = Mana("KP", "7C", "2P", "3C", "6I")
  require(mana2 > mana1)

  println(Mana("JP", "JC", "2P", "3C", "6I")) //> Mana("JT","JI","2T","3I","8C")) {
  //    println("player2 castiga")
  //  }


  val cartiDupaValoare = mana1.carti.groupBy(_.valoare)
  println(cartiDupaValoare("2"))
  val areFix1Pereche = 2 == cartiDupaValoare.values.count(_.size == 2)
  println(areFix1Pereche)

  val seturiCuSize2 = cartiDupaValoare.values.filter(_.size == 2)
  println(seturiCuSize2)
}
