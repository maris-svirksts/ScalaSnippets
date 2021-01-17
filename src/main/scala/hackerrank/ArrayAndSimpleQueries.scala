package hackerrank

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object ArrayAndSimpleQueries {

  sealed abstract class Command extends Product with Serializable
  object Command {
    final case class ToFront(start: Int, end: Int) extends Command
    final case class ToBack(start: Int, end: Int) extends Command
  }

  @tailrec
  def loop(commands: IndexedSeq[Command], data: Array[Long]): Array[Long] = {
    if(commands.isEmpty) data
    else {
      commands.head match {
        case Command.ToFront(start, end) =>
          val before:  Array[Long] = data.slice(0, start)
          val current: Array[Long] = data.slice(start, end)
          val after:   Array[Long] = data.slice(end, data.length)
          loop(commands.tail, Array(current, before, after).flatten)

        case Command.ToBack(start, end) =>
          val before:  Array[Long] = data.slice(0, start)
          val current: Array[Long] = data.slice(start, end)
          val after:   Array[Long] = data.slice(end, data.length)
          loop(commands.tail, Array(before, after, current).flatten)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val nm           = readLine().trim.split(" ").map(_.toInt)
    val elementArray = readLine().trim.split(" ").map(_.toLong)

    val input: IndexedSeq[Command] = for {
      _ <- 1 to nm(1)
      data = readLine().trim.split(" ").map(_.toInt)
    } yield data match {
      case _ if data(0) == 1 => Command.ToFront(data(1) - 1, data(2))
      case _ if data(0) == 2 => Command.ToBack(data(1) - 1, data(2))
    }

    val results: Array[Long] = loop(input, elementArray)

    println(math.abs(results.head - results.last))
    println(results.mkString(" "))
  }
}

