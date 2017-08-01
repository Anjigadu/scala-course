import scala.io.Source

object Chapter8_Functions extends App {

  def processFile(fileName: String, width:Int) = {
    def processLine(line:String) = { // local function
      if (line.length > width)
        println(fileName + ": " + line.trim) // fileName and width come from this
      // local function's clojure : metoda processFile care o contine
      // poti sa referi param de met, variab, campuri ale intantei in care esti
    }
    val source = Source.fromFile(fileName)
    for (line <- source.getLines())
    processLine(line)
  }

  processFile("course/src/Chapter8_Functions.scala", 20)

//  val increase =
  val list:Array[Int] = Array(1,2,3)
  val isOdd = (e:Int) => e % 2 == 0
  // e => e % 2 == 0    este un "function literal"
  list.filter(isOdd)

  list.filter(e => e % 2 == 0) // scala compiler isi da seama ca e trebuie se fie de tip Int
  // pentru ca filter asteapta un ~Predicat<Int>


  var delta = 1
  val increaser = (x:Int) => x + delta

  println(increaser(3))

  delta = 10
  println(increaser(3))

  // o functie care primeste param sau intoarce o alta functie se
  // numeste "Higher Order Function"
  def makeIncrementer(): () => Int = {
    // () => Int  este o functie care nu ia param dar iti da un Int inapoi
    var currentValue = 0
    () => {
      currentValue += 1
      currentValue
    }
  }
  val inc = makeIncrementer()
  //aici metoda makeIncrementer s-a terminat
  // si a fost eliverata din stiva
  // UNDE MAMA MASII A RAMAS CURRENT VALEUUUU ?
  println(inc())
  println(inc())
  println(inc())
  println(inc())
  println(inc())
  // Scala pune in astfel de situatii currentValue in HEAP, nu pe STIVA

  ///////// end of horror


  ////// compact function forms
  val numere:Array[Int] = Array(-1,2,5,-7,3)
  numere.filter(x => x > 0).foreach(x => println(x))
  numere.filter(_ > 0).foreach(println(_))   // _ tine locul parametrilor, in ordinea in care vin

  numere.sortWith( (a, b) => a < b).foreach(println(_))
  numere.sortWith( _ < _ ).foreach(println(_))
  // asta merge pentru ca in fct de mai sus era a < b nu b < a !!!!

//  val lt = _ < _ // nu compileaza pentru ca Scala nu stie ce tip au _-rile
  val lt = (_:Int) < (_:Int)

}
