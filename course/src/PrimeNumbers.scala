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
    var count = 0
    for (i <- 2 to num) {
      if (isPrim(i)) {
        count += 1
        println(i)
      }
    }
    println(s"Pana la $num sunt $count numere prime.")
    count
  }

  nrPrime(10000)

}