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
    dto.creationDate = entity.date //de formatat
    dto
  }
  println(toDto(new User).creationDate)
}

object OrderMapper {
  def toDto(entity: User): UserDto = {
    val dto = new UserDto
    dto.creationDate = entity.date // scala avea un Date dar trebuia sa obtina un String
    dto
  }
}
