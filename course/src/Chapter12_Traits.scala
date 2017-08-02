// diferenta intre interfata si clasa abstracta:
// in Java: nu poti extinde doua clase abstract, dar poti implem 2 interf
// In java7: (1) O interfata: nu are met concrete. (2) Nu are campuri, ci doar constante
// In java8: (1) Nu are campuri, ci doar constante

class Point(val x:Int, val y:Int)

//abstract class Shape { // poate fi si abstract class fara probleme
trait Shape {
  val topLeft:Point
  val bottomRight:Point
  def width:Int = bottomRight.x - topLeft.x
  def height:Int = topLeft.y - bottomRight.y
}


class Square(override val topLeft:Point, val edge:Int) extends Shape {
  override val bottomRight: Point = new Point(topLeft.x+edge, topLeft.y-edge)

}

object Chapter12_Traits extends App {

  val CONST=1
  val sq = new Square(new Point(3,3), 2)
  println(sq.width)
  println(sq.height)
}
