
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

val ss:String = "Kk"
ss.toLowerCase()
val ch = ss(2)


// String[] altArray = new String[] {"one", "two", "three"}
val altArray:Array[String] = Array("one", "two", "three")
//                          = Array.apply("one", "two", "three") // scala compiler traduce orice "invocare"
// de clasa intr-o metoda 'statica' apply pe Companion Object-ul acelei clase

//val primaList