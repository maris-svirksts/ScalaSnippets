package hackerrank

import scala.annotation.tailrec

object EvaluatingEX {

  @tailrec
  def loop(number: Double, sum: Double, iterator: Int, iteratorFactorial: Long): Double = {
    if(iterator == 10) sum
    else {
      val nextIterator: Int   = iterator + 1
      val nextFactorial: Long = iteratorFactorial * nextIterator
      val nextSum: Double     = sum + (math.pow(number, iterator) / iteratorFactorial)

      loop(number, nextSum, nextIterator, nextFactorial)
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine().trim.toInt

    for (nItr <- 1 to n) {
      val x: Double = stdin.readLine().trim.toDouble
      val results: Double = loop(x, 1, 1, 1)

      println(results)
    }
  }
}

