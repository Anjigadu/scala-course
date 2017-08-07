object PrimeNumbers extends App {


  def isPrim(num: Int): Boolean = {
    def isPrimeVsNrFrom(div: Int): Boolean = {
      if (div >= num) true
      else if (num % div == 0) false
      else isPrimeVsNrFrom(div + 1)
    }
    isPrimeVsNrFrom(2)
  }


  def nrPrime(num: Int): Int = {
    val numbers = (2 to num).filter(isPrim)
    numbers.foreach(println)
    val count  = numbers.length
    println(s"Pana la $num sunt $count numere prime.")
    count
  }

  nrPrime(10000)

}