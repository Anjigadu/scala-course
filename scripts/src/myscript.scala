import scala.collection.mutable

println("hello Scala!")

val x = 1
println("valoarea este " + x)
//x = 2 -- nu merge, val ~== final in Java

var y = 1
y = 3

var s:String = "abc"

def max(a:Int, b:Int): Int = {
  val z = if (a < b) b else a
  // b = 2 //  method arguments are implicitly "val"
  z
  // a < b ? b : a
}

println(max(x, y))

// Unit ~= void din Java
def greet(): Unit = println("Hello FP AND OOP!")

greet()


println("First arg: " + args(0))

// Programare imperativa. Long Live Basic!!
var i = 0
while (i < args.length) {
  print(args(i))
  if (i != args.length - 1) print(" ")
  i += 1
}

val ar:Array[String] = args // trick IntelliJ to offer autocomplete for Array methods

// Programare functional. Long Live Scala!!
ar.foreach( (arg: String) => { println(arg) }) // the most verbose

// list.forEach(s -> System.out.println(s))
ar.foreach(arg => println(arg))

// list.forEach(System.out::println)
ar.foreach(println)


for (arg <- ar) {
  println(arg)
//  arg = "x" // for loop elements are implicitly "val"
}


val greetStrings = new Array[String](3) // in Java: = new String[3]
greetStrings(0) = "a"
greetStrings(1) = "b"
greetStrings(2) = "c"
greetStrings.update(2, "c") // scala compile translates the above line in this
// Array este mutabil (ii poti schimba starea interioara a unei anumite instante)

for (e <- greetStrings) println(e)

for (i <- 0 to 2) {
//  println(greetStrings(i))
  println(greetStrings.apply(i)) // scala compile translates the above line in this
}

//apply(index:Int): T

val ss:String = "Kka"
ss.toLowerCase()
val ch:Char = ss(2) //echivalent cu ss.apply(2)


// String[] altArray = new String[] {"one", "two", "three"}
val altArray:Array[String] = Array("one", "two", "three")
//                          = Array.apply("one", "two", "three") // scala compiler traduce orice "invocare"
// de clasa intr-o metoda 'statica' apply pe Companion Object-ul acelei clase
println(altArray)

val primaLista:List[String] = List("one", "two", "three")
println(primaLista)

val listaGoala = Nil
println(listaGoala)

val oListaCu2Elem = (1 :: (2 :: Nil))
val oListaCu2Elem2 = 1 :: 2 :: Nil
val oListaCu2Elem3 = Nil.::(2).::(1)

// 1 + 2 == 1.+(2) // toti operatorii/metodele  din scala sunt
                // asociativi la stanga. La dreapta sunt doar cei care se temrmina cu :

// "abc".indexOf("a") == ("abc" indexOf "a")
// "abc".indexOf("a",1) == ("abc" indexOf ("a", 1)) // operatorii sunt metode si vice versa.
//!! Atentie la asociativitate

println(oListaCu2Elem(1))

// in java .add(3) . sau NU
val oNouaListaCu3Elem = oListaCu2Elem :+ 3

println(oListaCu2Elem)
println(oNouaListaCu3Elem)

println("primul element " + oListaCu2Elem.head)
println(", restu... " + oListaCu2Elem.tail)

// .stream().anyMatch(i -> i % 2 == 0)
println("has even number: " + oListaCu2Elem.exists(i => i % 2 == 0))

// .stream().filter(i -> i % 2 == 1)
println("odd numbers: " + oNouaListaCu3Elem.filter(i => i % 2 == 1).mkString("-"))

println("args with spaces : " + ar.mkString(" "))

println("Sorted args: " + ar.sortWith((s1,s2) => s1 < s2).mkString("|"))

//x == y
//  x<y = false
//  y<x = false
//
//x < y
//  x<y = true
//  y<x = false
//
//x > y
//  x<y = false
//  y<x = true

//compare(a:String, b:String, lt:func) {
//  if ()
//}



// Tuple
val pair = (11, "eleven")
println("first component " + pair._1)

// set
val set:scala.collection.immutable.Set[String] = Set("a","b","a","c","d","e","f")
println(set)

val nouSet = set + "Gigi"
println(nouSet)

var unSetReassignabil = Set(1,2,3)
unSetReassignabil += 4 // se re-asigneaza VARiabila, ca mai jos
unSetReassignabil = unSetReassignabil + 5

println(unSetReassignabil)

println("Contine pe 5? " + unSetReassignabil.contains(5))
println("Contine pe f? " + set("f")) // metoda .apply din set intoarce true sau false, e ~= .contains()

val unSetMutabil  = mutable.Set("X","Y","Z") // final Set<String> unSetMutabile = new HashSet<>(..)
unSetMutabil += "T" // Java-like. WTF!! += e o metoda in cazul asta!!
println(unSetMutabil)


