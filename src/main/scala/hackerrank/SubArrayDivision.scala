package hackerrank

import java.io._
import scala.io._

object SubArrayDivision {

  // Complete the birthday function below.
  def birthday(s: Array[Int], d: Int, m: Int): Int = {
    val results = s.sliding(m, 1).count(x => {
      x.sum == d
    })

    results
  }

  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toInt

    val s = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    val dm = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val d = dm(0).toInt

    val m = dm(1).toInt

    val result = birthday(s, d, m)

    printWriter.println(result)

    printWriter.close()
  }
}

