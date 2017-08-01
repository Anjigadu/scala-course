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



}
