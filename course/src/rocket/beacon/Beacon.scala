package rocket.beacon


import rocket.Rocket
//import java.util.List;




class Beacon {

  def metoda = {
    import java.util.regex._ // importurile pot fi puse in ORICE bloc
    //import java.util.regex.*; in Java
    val ok = Pattern.compile("\\d{10}").matcher("1234567890").matches()

    for (i <- 1 to 10) {
      import java.lang.System.currentTimeMillis
      //import static java.lang.System.currentTimeMillis; in Java

      println("Timpul acum este: " + currentTimeMillis())
    }

    val ok2 = "\\d{10}".r.findAllMatchIn("1234567890")
  }

  def metoda2 = {
    import java.util.regex //in Scala poti importa pachete intregi
    regex.Pattern.compile("\\d") // din simbolul regex mergi mai departe
  }

  def javaUtilDateERau = {
    //import java.util.Date identic cu:
    //import java.util.{Date}
    import java.util.{Date => BadDate}
    val dataRea = new BadDate()
  }

  def interzisJavaUtilDateDeTot = {
    import java.util.{Date => _} // ascund o clasa dintr-un pachet..
    val dataRea = new Date()
  }

  new Rocket
}
