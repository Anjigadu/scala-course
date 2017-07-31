class Telefon(cc:String, ln:String) {
  private val countryCode: String = cc
  private val localNumber: String = ln

//class Telefon(private val countryCode:String,
//              private val localNumber:String) {
//  private val countryCode: String = cc
//  private val localNumber: String = ln

  override def equals(obj: scala.Any): Boolean =
    if (!obj.isInstanceOf[Telefon]) false
    else {
      val other = obj.asInstanceOf[Telefon]
      this.countryCode == other.countryCode && this.localNumber == other.localNumber
    }


  override def toString: String = s"$this.countryCode $this.localNumber"
}
/*
public class Telefon {
  private final String countryCode, localNumber;
  public Telefon(String cc, String ln) {
    countryCode = cc;
    localNumber = ln;
  }
 */

object TelefonPlay extends App {
  val t1 = new Telefon("+4", "0720019564")
  val t2 = new Telefon("+4", "0720019564")
  println(t1 == t2)
}