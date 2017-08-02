abstract class Element {
  def contents: Array[String] // tine continutul linie cu linie
  def height(): Int = contents.length
  def width: Int = if (contents.isEmpty) 0 else contents(0).length
}

class ArrayElement(cons: Array[String]) extends Element {
  override val contents: Array[String] = cons
  // override este OBLIGATORIU DACA suprascrii o metoda. Optional Daca o IMPLEMENTEZI
}


object Chapter10_OOP extends App {

  val primuElem = new ArrayElement(Array("abc"))

  println(primuElem.contents)
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
}
