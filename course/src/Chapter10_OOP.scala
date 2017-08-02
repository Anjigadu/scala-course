import Chapter10_OOP.strings

import scala.collection.mutable.ArrayBuffer

abstract class Element {
  def contents: Array[String] // tine continutul linie cu linie
  def height(): Int = contents.length
  def width: Int = if (contents.isEmpty) 0 else contents(0).length
  val name:String
  def above(other: Element):Element = new ArrayElement(contents ++ other.contents)
  def beside(other: Element):Element = {
    require(other.contents.length == contents.length)
    val shmecher = for ((a, b) <- contents zip other.contents) yield a + b
    new ArrayElement(shmecher
    )
  }

  override def toString: String = contents.mkString("\n")
}

// override este OBLIGATORIU DACA suprascrii o metoda. Optional Daca o IMPLEMENTEZI
class ArrayElement(initialContent: Array[String]) extends Element {
  override val contents:Array[String] = uniformPad(initialContent)

  def uniformPad(lines:Array[String]):Array[String] = {
    val longestLine:String = lines.maxBy(_.length)
    val maxLength:Int = longestLine.length

    def padLine(line: String) = {
      val halfNoSpaces = (maxLength - line.length) / 2
      val halfPadding = " " * halfNoSpaces
      halfPadding + line + halfPadding
    }

    for (line <- lines) yield padLine(line)
  }

  // implementing an abstract function fara () cu o variabila/valoare !!!!
  // "Uniform access principle" inseamna ca implementarea unei fct abstract fara () poate fi un camp.
  // DPDV al clientului nu ar trebui sa conteze
  val name = "ArrayElem"
  //def name = "ArrayElem" -- NU poti implementa un VAL ABSTRACT cu un DEF, dar poti implementa un DEF ABSTRACT cu un VAL
}

//new ArrayElement(Array("rosu","galben","albastru"))

class LineElement(line:String) extends Element {
  def contents = Array(line)
  val name = "LineElem" // In scala final opreste override. Atat!
  override def width = line.length
  override def height = 1
}

class UniformElement(ch:Char, width:Int, height: Int) extends Element {
  override def contents: Array[String] = Array.fill[String](height)(ch.toString * width)
  override val name: String = "UniformElem"
}

object Chapter10_OOP extends App {
  val primuElem = new ArrayElement(Array("abc"))
//  println(primuElem.contents()) // nu compileaza pt ca functia ai declarat-o FARA ()

  // DAR daca ai declarat-o cu (), poti sa o apelezi si CU si FARA :
  primuElem.height()
  primuElem.height

//  val column1 = elem("Hello") above elem("***")
//  val column2 = elem("***") above elem("World")
//  val bloc = column1 beside column2
//  println(bloc)
  // hello ***
  //  *** world

//  println((new OClasaMica).i)

  val ue = new UniformElement('*', 3, 2)
  println(ue)

  val steagRO = new LineElement("rosu") above new LineElement("galben") above new LineElement("albastru")
  println(steagRO)
  val steagFR = new LineElement("rosu") above new LineElement("maro") above new LineElement("albastru")

  val steaguri = steagRO beside steagFR
  println(steaguri)

  val strings = Array("rosu", "galben")

//  println(paddedStrings.mkString("\n"))

//  var orderList = Array(order1,order...)
//
//  val lastOrder = orderList.maxBy(_.creationDate)


  val stringList = Array("a","b","c")
  val intList = Array(1,2,3)

  println((stringList zip intList).mkString("\n"))
}






class CampPublicModificabil(var j:Int)
class CampPublicImutabil(val j:Int)
class CampPrivatImutabil(private val j:Int)
class CampPrivatModificabil(private var j:Int)
class CampImmutabilCareNuPoateFiSuprascrisInSubclase(final val j:Int)
class CampPublicCareSuprascrieCeva(override val j:Int) extends CampPublicImutabil(j)

class OClasaMica(final private val j:Int) {
  var s:String = _
  var i:Int = _
}