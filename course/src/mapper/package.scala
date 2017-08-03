import java.text.SimpleDateFormat
import java.util.Date


package object mapper {
  implicit def conversie(date:Date):String =
    new SimpleDateFormat("yyyy-MM-dd").format(date)
}
