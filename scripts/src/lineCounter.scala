import scala.io.Source

val ar: Array[String] = args

val lines = Source.fromFile(ar(0)).getLines().filter(line => line != "").toList

val maxLength: Int = lines.map(line => line.length).max
val maxPad = maxLength.toString.length

println(maxPad)
for (line <- lines) {
  val pad = " " * (maxPad - line.length.toString.length)
  println(pad + line.length + "|" + line)
}

