package hackerrank

import java.io._

object SalesByMatch {

  // Complete the sockMerchant function below.
  def sockMerchant(n: Int, ar: Array[Int]): Int = {
    ar.toList.groupBy(x => x).map(x => { x._2.length / 2 }).sum
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine().trim.toInt

    val ar = stdin.readLine().split(" ").map(_.trim.toInt)
    val result = sockMerchant(n, ar)

    printWriter.println(result)

    printWriter.close()
  }
}

