package hackerrank

import java.io._
import scala.io._

object DiagonalDifference {

  /*
   * Complete the 'diagonalDifference' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY arr as parameter.
   */

  def diagonalDifference(arr: Array[Array[Int]], n: Int): Int = {
    // Write your code here
    val leftToRight = for (i <- 0 until n) yield arr(i)(i)
    val rightToLeft = for (i <- 0 until n) yield arr(i)(n - i - 1)

    println(leftToRight)
    println(rightToLeft)
    math.abs(leftToRight.sum - rightToLeft.sum)
  }

}

object SolutionDiagonalDifference {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine().trim.toInt

    val arr = Array.ofDim[Int](n, n)

    for (i <- 0 until n) {
      arr(i) =
        StdIn.readLine().replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    val result: Int = DiagonalDifference.diagonalDifference(arr, n)

    printWriter.println(result)

    printWriter.close()
  }
}
