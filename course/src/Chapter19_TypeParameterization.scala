trait FunQueue[T] {
  def enqueue(x:T):FunQueue[T]
  def head(): T
  def dequeue(): FunQueue[T]
}

class QueueImpl[T](intrareUser: List[T] = Nil, iesireUser: List[T] = Nil) extends FunQueue[T] {
  private def nuTrebuieInversata = iesireUser.nonEmpty
  val iesire = if (nuTrebuieInversata) iesireUser else intrareUser.reverse
  val intrare = if (nuTrebuieInversata) intrareUser else Nil

  override def enqueue(x: T): FunQueue[T] = new QueueImpl[T](x :: intrare, iesire)
  override def head(): T = iesire.head
  override def dequeue(): FunQueue[T] = new QueueImpl(intrare, iesire.tail)
}

object Chapter19_TypeParameterization extends App{

  var q:FunQueue[Int] = new QueueImpl[Int]()
  q = q.enqueue(1)

  println(q.head())
  q = q.dequeue()

  q = q.enqueue(2)
  println(q.head())
  q.dequeue()
  q = q.enqueue(3)
}
