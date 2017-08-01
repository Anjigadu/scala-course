import java.io.FileNotFoundException

import scala.io.Source

def printLines(ar: Array[String]):Unit = {

  val lines = readLines(ar)
  val maxLength: Int = lines.map(line => line.length).max
  val maxPad = maxLength.toString.length

  println(maxPad)
  for (line <- lines) {
    val pad = " " * (maxPad - line.length.toString.length)
    println(pad + line.length + "|" + line)
  }

}

def error(message: String): Nothing =
  throw new RuntimeException(message) // tipul unei expressi throw este Nothing. Altfel, n-ai cum sa instantiezi Nothing

def readLines(ar: Array[String]): List[String] = {
  if (ar.length != 1)
//    throw new IllegalArgumentException
    //require(ar.length == 1)
    return error("Trebe macar un argument, frate")
  else {
    try {
      Source.fromFile(ar(0)).getLines().filter(line => line != "").toList
    } catch {
      case eCarmaz : FileNotFoundException => throw new IllegalArgumentException("Fisieru nu-i", eCarmaz)
      case altCarmaz: java.io.IOException => throw new IllegalArgumentException("Altceva rau", altCarmaz)
    }

  }
}
printLines(args)