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
          val _@(before: Array[Long], continue: Array[Long]) = data.splitAt(start)
          val _@(current: Array[Long], after: Array[Long]) = continue.splitAt(end - start + 1)
          System.err.println("before: " + before.toList + ", current: " + current.toList + " , after: " + after.toList)
          loop(commands.tail, current ++ before ++ after)

        case Command.ToBack(start, end) =>
          val _@(before: Array[Long], continue: Array[Long]) = data.splitAt(start)
          val _@(current: Array[Long], after: Array[Long]) = continue.splitAt(end - start + 1)
          System.err.println("before: " + before.toList + ", current: " + current.toList + " , after: " + after.toList)
          loop(commands.tail, before ++ after ++ current)

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
      case _ if data(0) == 1 => Command.ToFront(data(1) - 1, data(2) - 1)
      case _ if data(0) == 2 => Command.ToBack(data(1) - 1, data(2) - 1)
    }

    val results: Array[Long] = loop(input, elementArray)

    println(math.abs(results.head - results.last))
    println(results.mkString(" "))
  }
}
