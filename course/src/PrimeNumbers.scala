object PrimeNumbers extends App {


  def isPrim(num: Int): Boolean = {
    for (i <- 2 until num) {
      if (num % i == 0) return false
    }
    true
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