abstract class Element {
  def contents: Array[String] // tine continutul linie cu linie
  def height(): Int = contents.length
  def width: Int = if (contents.isEmpty) 0 else contents(0).length
  val name:String
}

// override este OBLIGATORIU DACA suprascrii o metoda. Optional Daca o IMPLEMENTEZI

class ArrayElement(val contents: Array[String]) extends Element {
  // implementing an abstract function fara () cu o variabila/valoare !!!!
  // "Uniform access principle" inseamna ca implementarea unei fct abstract fara () poate fi un camp.
  // DPDV al clientului nu ar trebui sa conteze

  val name = "ArrayElem"
  //def name = "ArrayElem" -- NU poti implementa un VAL ABSTRACT cu un DEF
  // dar poti implementa un DEF ABSTRACT cu un VAL
}

class LineElement(line:String) extends ArrayElement(Array(line)) {
  override val name = "LineElem" // In scala final opreste override. Atat!
  override def width = line.length
  override def height = 1
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
