class Rational(numarator2:Int, numitor2:Int) {
  // cod care ruleaza in constructorul default
  require(numitor != 0)

  private val numarator:Int = numarator2
  private val numitor:Int = numitor2

  def add(other: Rational): Rational =
    new Rational(this.numarator * other.numitor + this.numitor * other.numarator, this.numitor * other.numitor)

  override def toString: String = s"$numarator / $numitor"
}

// new Rational(1, 2) + new Rational(1, 2)  == new Rational(1)

object RationalPlay extends App {
  val oneHalf = new Rational(1, 2)
  val one = new Rational(2, 2)
//  val inf = new Rational(1, 0)
  println(oneHalf)

  val twoThirds = new Rational(2, 3)
  println(oneHalf.add(twoThirds))
  println(oneHalf.add(oneHalf))

}