import java.io.File

import scala.io.Source
import scala.runtime.RichInt

object Chapter7 extends App {


  ////////////////////////////// IF //////////////////////////

  println(args.mkString(","))

  var filenameJavaStyle = "default.txt"
  if (! args.isEmpty) {
    filenameJavaStyle = args(0)
  }

  println("Variabila este " + filenameJavaStyle)


  val filenameScalaStyle =  if (! args.isEmpty) args(0) else "default.txt"

  println("Variabila este " + filenameScalaStyle) // CTRL-ALT-N  (Inline) merge brici daca lucrezi cu valori

  //// if or throw

  var filenameOrThrowJavaStyle = "default.txt"
  if (args.isEmpty) {
    throw new IllegalArgumentException
  } else {
    filenameOrThrowJavaStyle = args(0)
  }

  val filenameScalaOrThrowStyle =  if (! args.isEmpty) args(0) else throw new IllegalArgumentException
  // expresia if.... are tipul String pentru ca "throw new ..." are tipul Nothing

  ////////////////////////// UNIT type /////////////////////////

  val voidInstance: Unit = ()
  val b = println() == ()
  println("println intoarce void: " + b)


  var y = "a"
  val ss = (y = "j")
  println("rezultatul unei asignari este Unit: " + ss)



  //////////////////////// FOR ///////////////////////////////////////////
  val currentDir = new File("""course\src""")
  println(s"Sunt in ${currentDir.getAbsolutePath}")

  val filesHere = currentDir.listFiles

  for (i <- 0 until filesHere.length) println("Fis: " + filesHere(i))
  // until  este === "to <val> -1"

  def fileLines(file: File) = Source.fromFile(file).getLines.toList

  val ceoFii =
  for (file <- filesHere // -- asta e un "generator"
       if file.getName.endsWith(".scala"); // conditii. TREBUIE ";"
       line<-fileLines(file); // ~=Stream.flatMap (Java8) sau for in for (java7)
       trimmed = line.trim //def de variabile intermediare
    ) yield trimmed // yield exact dupa paranteza ) a forului

  println(ceoFii.mkString(","))




  for (i <- 10 to (1,-1)) println(s"Pasul $i")
  for (i <- 10 to (step= -1, end=1)) println(s"Pasul $i")
  for (i <- 10.to(end=1, step= -1)) println(s"Pasul $i")

  //  filesHere.foreach(println)

  /// definirea unui operator nou pe int "downto"
  class MyRichInt(val i:Int) {
    def downto(j:Int):Range = i to (j, -1)
  }
  implicit def intToMyRichInt(i:Int):MyRichInt = new MyRichInt(i)
  for (i <- 10 downto 1) println(s"Pasul $i")


  //////////////
}
