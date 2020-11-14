package hackerrank.tests
// https://stackoverflow.com/questions/27723858/count-elements-of-array-a-in-array-b-with-scala


import java.io._

import scala.annotation.tailrec
import scala.io._



object Result {

  /*
   * Complete the 'filledOrders' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY order
   *  2. INTEGER k
   */

  def filledOrders(order: Array[Int], k: Int): Int = {

    @tailrec
    def loop (orders: Array[Int]): Int = {
      if(orders.sum <= k ) orders.length
      else loop(orders.init)
    }

    loop(order.sorted)
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val orderCount = StdIn.readLine.trim.toInt

    val order = Array.ofDim[Int](orderCount)

    for (i <- 0 until orderCount) {
      val orderItem = StdIn.readLine.trim.toInt
      order(i) = orderItem
    }

    val k = StdIn.readLine.trim.toInt

    val result = Result.filledOrders(order, k)

    printWriter.println(result)

    printWriter.close()
  }
}
