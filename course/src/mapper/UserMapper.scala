package mapper

import java.text.SimpleDateFormat
import java.util.Date

class User {
  val date:Date = new Date()
}
class UserDto {
  var creationDate:String = _
}
object UserMapper extends App {

  def toDto(entity: User): UserDto = {
    val dto = new UserDto
    dto.creationDate = MapperUtils.dateToString(entity.date) //de formatat
    dto
  }


  println(toDto(new User).creationDate)
}

private[mapper] object MapperUtils {
  def dateToString(date: Date) = {
    new SimpleDateFormat("yyyy-MM-dd").format(date)
  }

}