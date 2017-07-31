
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