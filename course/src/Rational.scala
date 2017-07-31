class Rational(numarator2:Int, numitor2:Int) {
  // cod care ruleaza in constructorul default

  private val numarator:Int =  numarator2 / gcd(numarator2, numitor2)
  private val numitor:Int = numitor2 / gcd(numarator2, numitor2)
  require(numitor != 0)

  def this(numarator3:Int) = this(numarator3, 1)

  def +(other: Rational): Rational =
    new Rational(this.numarator * other.numitor + this.numitor * other.numarator, this.numitor * other.numitor)

  def *(other: Rational): Rational =
    new Rational(numarator * other.numarator, numitor * other.numitor)

  def *(i: Int): Rational = this * Rational(i)

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString: String =
    if (numitor == 1)
      numarator.toString
    else {
      val sig = math.signum(numitor)
      s"${numarator * sig} / ${numitor * sig}"
    }
}

object Rational {
  def apply(numarator: Int, numitor: Int): Rational = new Rational(numarator, numitor)
  def apply(numarator: Int): Rational = new Rational(numarator)

}


object RationalPlay extends App {
  implicit def intToRationalCaremaz(i:Int): Rational = Rational(i)
  val oneHalf = new Rational(1, 2)
  val one = new Rational(2, 2)
//  val inf = new Rational(1, 0)
  println(oneHalf)

  val twoThirds = new Rational(2, 3)
  println(oneHalf + twoThirds)
  println(oneHalf + oneHalf)

  println(new Rational(1, 6) * new Rational(3, 1))
  println((oneHalf + twoThirds) * oneHalf)
  println(oneHalf * new Rational(2))
  println(new Rational(-1,2))
  println(new Rational(1,-2))
  println(Rational.apply(-1,-2))
  println(Rational(-1,-2))
  println(Rational(1, 2) * 2)
  println(2 * Rational(1, 2))
}