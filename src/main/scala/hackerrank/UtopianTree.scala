package hackerrank

import java.io._
import scala.annotation.tailrec

object UtopianTree {

  // Complete the utopianTree function below.
  def utopianTree(n: Int): Int = {
    @tailrec
    def loop(period: Int, height: Int): Int = {
      if(period == n) height
      else if(period % 2 == 0) loop(period + 1, height * 2)
      else loop(period + 1, height + 1)
    }

    loop(0, 1)
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val t = stdin.readLine().trim.toInt

    for (tItr <- 1 to t) {
      val n = stdin.readLine().trim.toInt

      val result = utopianTree(n)

      printWriter.println(result)
    }

    printWriter.close()
  }
}

