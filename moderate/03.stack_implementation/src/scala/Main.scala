import scala.annotation.tailrec
import scala.util.Try

case class Stack(private val elems: Seq[Int]) {
  def this() = this(Nil)

  def isEmpty: Boolean = elems.isEmpty

  def head: Int = elems.head

  def tail: Stack = new Stack(Try(elems.tail).toOption.getOrElse(Nil))

  def pop: Stack = new Stack(Try(elems.tail).toOption.getOrElse(Nil))

  def push(elem: Int): Stack = new Stack(elem +: elems)

  override def toString = elems.mkString("Stack(", ",", ")")
}

object Stack {
  def empty: Stack = new Stack()

  def fromString(string: String): Option[Stack] = {
    Try {
      string.split("\\s+")
        .map(_.toInt)
        .foldLeft(Stack.empty)((acc, e) => acc.push(e))
    }.toOption
  }

  def iterAlternating(stack: Stack): List[Int] = {
    @tailrec def loop(stack: Stack, acc: List[Int] = Nil): List[Int] = {
      if (stack.isEmpty) acc
      else loop(stack.tail.pop, acc :+ stack.head)
    }
    loop(stack)
  }
}

object Main extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines().filter(_.length > 0)
  val results = for {
    line <- lines
    stack <- Stack.fromString(line)
  } yield Stack.iterAlternating(stack)
  results.foreach(res => println(res.mkString(" ")))
}