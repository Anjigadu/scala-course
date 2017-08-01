import java.io.File

object Chapter9_ControlAbstraction extends App {

  private def filesHere = (new File("course\\src")).listFiles



  def filesEnding(suffix: String):Array[File] = {
    def matches(fileName: String) = fileName.endsWith(suffix)
    for (file <- filesHere if matches(file.getName)) yield file
  }

  def filesContaining(bucata: String):Array[File] = {
    def matches(fileName: String) = fileName.contains(bucata)
    for (file <- filesHere if matches(file.getName)) yield file
  }


  println(filesEnding(".scala").mkString("=="))
  println(filesContaining("Chap").mkString("--"))

}
