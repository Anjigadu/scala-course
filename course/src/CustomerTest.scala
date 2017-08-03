import org.scalatest.{BeforeAndAfter, FunSuite}

class CustomerTest extends FunSuite with BeforeAndAfter {

  test("this is called a 'characterization test' ") {
    val customer = new Customer("John Doe")
    customer.addRental(new Rental(new Movie("Star Wars", MovieType.NEW_RELEASE), 6))
    customer.addRental(new Rental(new Movie("Sofia", MovieType.CHILDRENS), 7))
    customer.addRental(new Rental(new Movie("Inception", MovieType.REGULAR), 5))
    val expected ="Rental Record for John Doe\n" +
      "\tStar Wars\t18.0\n" +
      "\tSofia\t7.5\n" +
      "\tInception\t6.5\n" +
      "Amount owed is 32.0\n" +
      "You earned 4 frequent renter points"
    assert(expected == customer.statement)
  }
}
