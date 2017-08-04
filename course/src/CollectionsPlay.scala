object CollectionsPlay {
  val raoul = Trader("Raoul", "Cambridge")
  val mario = Trader("Mario", "Milan")
  val alan = Trader("Alan", "Cambridge")
  val brian = Trader("Brian", "Cambridge")

  val transactions = Array(
    Transaction(brian, 2011, 300),
    Transaction(raoul, 2012, 1000),
    Transaction(raoul, 2011, 400),
    Transaction(mario, 2012, 710),
    Transaction(mario, 2012, 700),
    Transaction(alan, 2012, 950))


  //1 def all_2011_transactions_sorted_by_value()
  //2 def unique_cities_of_the_traders()
  // 3 def traders_from_Cabridge_sorted_by_name(): Unit
  // 4 def names_of_all_traders_sorted_joined(): Unit
  // 5 def are_traders_in_Milano(): Unit
  // 6  def sum_of_values_of_transactions_from_Cambridge_traders(): Unit =
  // 7 def max_transaction_value(): Unit =
  //def transaction_with_smallest_value()
  // def fibonacci_first_10()
  // def a_transaction_from_2012() =
  // def uniqueCharactersOfManyWords() =
  // def advanced_sum_using_consumer() =

}
case class Trader (name:String, city:String)
case class Transaction(trader:Trader, year:Int, value:Int)

