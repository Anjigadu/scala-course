import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.collection.mutable.ArrayBuffer

class Movie(val title: String, val movieType: MovieType.Value)
object MovieType extends Enumeration{
  val CHILDRENS = Value
  val REGULAR = Value
  val NEW_RELEASE = Value
}

class Rental(val movie: Movie, val daysRented: Int){
  def computePrice:Double = {

    this.movie.movieType match {
      case MovieType.REGULAR =>
        if (this.daysRented > 2) 2 + (this.daysRented - 2) * 1.5 else 2
      case MovieType.NEW_RELEASE =>
        this.daysRented * 3
      case MovieType.CHILDRENS =>
        if (this.daysRented > 3) 1.5 + (this.daysRented - 3) * 1.5 else 1.5
      case _ => throw new IllegalArgumentException("nu e voie!")
    }
  }

   def computeBonus(): Int = {
    if ((this.movie.movieType == MovieType.NEW_RELEASE) && this.daysRented > 1) 2 else 1
  }
}

class Customer(private val name: String) {
  private val rentals = new ArrayBuffer[Rental]()

  def addRental(arg: Rental): Unit = {
    rentals += arg
  }

  def statement(): String = {
    val triplets:Seq[(Double,Int,String)] = for (rental <- rentals) yield processRental(rental)
    val totalPrice = triplets.map(triplet => triplet._1).sum
    val totalFidelityPoints = triplets.map(triplet => triplet._2).sum
    val result = createHeader + triplets.map(triplet => triplet._3).mkString + createFooter(totalPrice, totalFidelityPoints)
    result
  }
  private def processRental(rental:Rental)={
    (rental.computePrice,rental.computeBonus(),createStatementLine(rental))
  }

  private def createHeader = {
    "Rental Record for " + name + "\n"
  }
  private def createStatementLine(rental: Rental) = {
    s"\t${rental.movie.title}\t${rental.computePrice}\n"
  }

  private def createFooter(totalPrice: Double, frequentRenterPoints: Int) = {
     s"Amount owed is $totalPrice\nYou earned $frequentRenterPoints frequent renter points"
  }


}