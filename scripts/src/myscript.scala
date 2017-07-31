
println("hello Scala!")

val x = 1
println("valoarea este " + x)
//x = 2 -- nu merge, val ~== final in Java

var y = 1
y = 3

var s:String = "abc"

def max(a:Int, b:Int): Int = {
  val z = if (a < b) b else a
  z
  // a < b ? b : a
}

println(max(x, y))

// Unit ~= void din Java
def greet(): Unit = println("Hello FP AND OOP!")

greet()