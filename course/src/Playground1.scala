object Playground1 extends App {
  val acc = new ChecksumAccumulator

  println("Hello first main()")

  acc.add(1);  acc.add(2) // daca vreau sa ingramadesc doua instr pe o sg linie, atunci e NEVOIE de ;

  println(acc.checksum)

  println("a".length)
  println("a".toLowerCase)

  val s = "Prima linie " +
    "A doua linie"

  println(AltObiectStatic.echo("hello"))

  println(ChecksumAccumulator.calculateCRC("Gigi"))
  println(ChecksumAccumulator.calculateCRC("Gigi"))

  val ss =
    """ Usage pattern
      | -cp <classpath> - meanse
      | -D<arg> - JVM argument
    """.stripMargin
  println(ss)

  val phone = "0720019564"
  phone.matches("""\d{10}""")

  val i = 2

  val xs = "Telefonul meu este " + phone + ", oricand"
  val xs2 = s"Telefonul meu este $phone, oricand ${i * 2}"

  println(xs2)
}
