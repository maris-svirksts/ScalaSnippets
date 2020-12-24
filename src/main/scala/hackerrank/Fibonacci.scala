package hackerrank

import scala.annotation.tailrec
import scala.io.StdIn

object Fibonacci {
  def fibonacciModulo(x: Int): Long = {
    val modulo: Int = math.pow(10, 8).toInt + 7

    @tailrec
    def loop(y: Int, a: Long, b: Long): Long = y match {
      case 0 => a
      case _ => loop(y - 1, b, (a + b) % modulo)
    }

    loop(x, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val numberOfLines: Int = StdIn.readLine().trim.toInt

    for( _ <- 0 until numberOfLines ){
      val element = StdIn.readLine().trim.toInt
      println(fibonacciModulo(element))
    }
  }
}
