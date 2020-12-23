package hackerrank

import java.io._
import scala.annotation.tailrec

object ViralAdvertising {

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine().trim.toInt

    val result = viralAdvertising(n)

    printWriter.println(result)

    printWriter.close()
  }

  // Complete the viralAdvertising function below.
  def viralAdvertising(n: Int): Int = {
    @tailrec
    def loop(day: Int, shares: Int, cumulativeLikes: Int): Int = {
      if (day == 1) cumulativeLikes
      else {
        val newShares = (shares / 2) * 3
        loop(day - 1, newShares, cumulativeLikes + (newShares / 2))
      }
    }

    loop(n, 5, 2)
  }
}