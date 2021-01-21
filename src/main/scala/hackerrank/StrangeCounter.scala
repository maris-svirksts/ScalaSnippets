package hackerrank

import java.io._
import scala.annotation.tailrec

object StrangeCounter {

  // Complete the strangeCounter function below.
  def strangeCounter(t: Long): Long = {
    @tailrec
    def loop(rem: Long, time: Long): Long = {
      if(time <= rem) rem - time + 1L
      else loop(rem * 2, time - rem)
    }

    loop(3, t)
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val t           = stdin.readLine.trim.toLong
    val result      = strangeCounter(t)

    printWriter.println(result)

    printWriter.close()
  }
}

