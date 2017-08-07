object PrimeNumbers extends App {


  def nrDivizori(num: Int): Int = {
    var count = 0
    for (i <- 1 to num) {
      if (num % i == 0) count += 1
      if (count > 2) return count
    }
    count
  }

  def isPrim(num: Int): Boolean = {
    nrDivizori(num) == 2
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

  nrPrime(100000)

}