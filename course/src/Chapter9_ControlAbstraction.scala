import java.io.File

object Chapter9_ControlAbstraction extends App {

  private def filesHere() = (new File("course\\src")).listFiles

  private def filesMatching(matches: (String) => Boolean):Array[File] = { // higher order func
    for (file <- filesHere() if matches(file.getName)) yield file
  }

  def filesEnding(suffix:String) = filesMatching(_.endsWith(suffix))
  def filesContaining(bucata:String) = filesMatching(_.contains(bucata))

  println(filesEnding(".scala").mkString("=="))
  println(filesContaining("Chap").mkString("--"))

}
