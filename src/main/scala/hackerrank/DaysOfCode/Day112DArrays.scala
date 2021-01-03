package hackerrank.DaysOfCode

import scala.io.StdIn.readLine

object Day112DArrays {

  def maximumSum(arr: Array[Array[Int]]): Int = {
    val width:  Int = arr.head.length
    val height: Int = arr.length

    (for{
      w <- 0 until width - 2
      h <- 0 until height - 2
    } yield List(
      arr(h)(w), arr(h)(w + 1), arr(h)(w + 2),
      arr(h + 1)(w + 1),
      arr(h + 2)(w), arr(h + 2)(w + 1), arr(h + 2)(w + 2)
    ).sum).max
  }

  def main(args: Array[String]) {
    val arr = Array.ofDim[Int](6, 6)

    for (i <- 0 until 6) {
      arr(i) = readLine.split(" ").map(_.trim.toInt)
    }

    println(maximumSum(arr))
  }
}

