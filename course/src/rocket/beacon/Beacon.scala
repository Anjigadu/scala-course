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
  new Rocket
}
