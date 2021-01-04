package hackerrank

import scala.annotation.tailrec
import scala.io.StdIn

object MaximumElement {

  sealed abstract class Command extends Product with Serializable
  object Command {
    final case class Push(amount: BigInt) extends Command
    final case class Delete() extends Command
    final case class Print() extends Command
  }

  @tailrec
  def loop(commands: IndexedSeq[Command], data: List[(BigInt, Int)], results: List[BigInt]): List[BigInt] = {
    if (commands.isEmpty) results
    else {
      commands.head match {
        case Command.Push(amount) =>
          if(amount <= data.headOption.getOrElse(BigInt(0), 0)._1) // It's known that the amount is always positive.
            loop(commands.tail, (data.head._1, data.head._2 + 1) :: data.tail, results)
          else
            loop(commands.tail, (amount, 1) :: data, results)
        case Command.Delete()     =>
          if(data.headOption.getOrElse(BigInt(0), 0)._2 > 1)
            loop(commands.tail, (data.head._1, data.head._2 - 1) :: data.tail, results)
          else
            loop(commands.tail, data.tail, results)
        case Command.Print()      =>
          loop(commands.tail, data, data.head._1 :: results)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val numberOfCommands: Long  = StdIn.readLine().trim.toLong

    val input: IndexedSeq[Command] = for{
      _ <- 1L to numberOfCommands
      data = StdIn.readLine().trim.split(" ")
    } yield data match {
      case _ if data(0).toInt == 1 => Command.Push(BigInt(data(1)))
      case _ if data(0).toInt == 2 => Command.Delete()
      case _ if data(0).toInt == 3 => Command.Print()
    }

    loop(input, List(), List()).reverse.foreach(x => println(x))
  }
}
