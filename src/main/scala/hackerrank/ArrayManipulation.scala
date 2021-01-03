package hackerrank

import java.io._
import scala.annotation.tailrec

//Arrays are instrumental here: Lists take too long.
object ArrayManipulation {
  @tailrec
  def applyManipulations(playingField: Array[Long], queries: Array[Array[Long]]): Long = {
    if(queries.isEmpty) {
      val result = playingField.filter(_ != 0).scanLeft(0L)(_ + _)
      result.max
    }
    else {
      val startIndice: Long = queries.head(0) - 1
      val endIndice:   Long = queries.head(1)

      val positiveResult: Long = playingField(startIndice.toInt) + queries.head(2)
      val negativeResult: Long = playingField(endIndice.toInt) - queries.head(2)

      playingField(startIndice.toInt) = positiveResult
      playingField(endIndice.toInt)   = negativeResult

      applyManipulations(playingField, queries.tail)
    }
  }

  // Complete the arrayManipulation function below.
  def arrayManipulation(n: Int, queries: Array[Array[Long]]): Long = {
    val playingField = Array.fill(n + 1)(0L)

    applyManipulations(playingField, queries)
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nm = stdin.readLine.split(" ")

    val n = nm(0).trim.toInt
    val m = nm(1).trim.toInt

    val queries = Array.ofDim[Long](m, 3)

    for (i <- 0 until m) {
      queries(i) = stdin.readLine.split(" ").map(_.toLong)
    }

    val result = arrayManipulation(n, queries)

    printWriter.println(result)

    printWriter.close()
  }
}

