package hackerrank

import java.io._
import scala.math.{ceil, floor, sqrt}

object SherlockAndSquares {

  // Complete the squares function below.
  def squares(a: Int, b: Int): Int = {
    val sqrtStart = ceil(sqrt(a)).toInt
    val sqrtEnd   = floor(sqrt(b)).toInt

    if(sqrtStart <= sqrtEnd) (sqrtStart to sqrtEnd).length
    else 0
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val ab = stdin.readLine.split(" ")

      val a = ab(0).trim.toInt

      val b = ab(1).trim.toInt

      val result = squares(a, b)

      printWriter.println(result)
    }

    printWriter.close()
  }
}

