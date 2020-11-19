package hackerrank

import java.io._

import scala.annotation.tailrec

object DivisiveSumPairs {

  // Complete the divisibleSumPairs function below.
  def divisibleSumPairs(arrayLength: Int, divider: Int, ar: Array[Int]): Int = {

    @tailrec
    def loop(currentArray: Array[Int], currentElement: Array[Int], result: Int): Int = {
      if (currentElement.length <= 1) result
      else if (currentArray.isEmpty) loop(currentElement.tail.tail, currentElement.tail, result)
      else if ((currentElement.headOption.getOrElse(0) + currentArray.headOption.getOrElse(0)) % divider == 0) loop(currentArray.tail, currentElement, result + 1)
      else loop(currentArray.tail, currentElement, result)
    }

    loop(ar.tail, ar, 0)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val ar = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = divisibleSumPairs(n, k, ar)

    printWriter.println(result)

    printWriter.close()
  }
}

