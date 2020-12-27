package hackerrank

import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'rotateLeft' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER d
   *  2. INTEGER_ARRAY arr
   */

  def rotateLeft(d: Int, arr: Array[Int]): List[Int] = {
    val rotatedElements: List[Int] = arr.toList.indices.map(x => {
      val shift: Int = d % arr.length
      val index: Int = (shift + x) % arr.length

      arr(index)
    }).toList

    rotatedElements
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n   = firstMultipleInput(0).toInt
    val d   = firstMultipleInput(1).toInt
    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.rotateLeft(d, arr)

    printWriter.println(result.mkString(" "))
    printWriter.close()
  }
}

