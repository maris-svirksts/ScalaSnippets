package hackerrank

import java.io._
import scala.annotation.tailrec

object Solution {
  @tailrec
  def applyManipulations(playingField: List[BigInt], queries: Array[Array[BigInt]]): BigInt = {
    if(queries.isEmpty) {
      playingField.scanLeft(BigInt(0))(_ + _).filter(_ != 0).max
    }
    else {
      val startIndice: BigInt = queries.head(0) - 1
      val endIndice: BigInt   = queries.head(1)

      val positiveResult: BigInt = playingField(startIndice.toInt) + queries.head(2)
      val negativeResult: BigInt = playingField(endIndice.toInt) - queries.head(2)

      val startedPlayingField = playingField.updated(startIndice.toInt, positiveResult)
      val updatedPlayingField = startedPlayingField.updated(endIndice.toInt, negativeResult)

      applyManipulations(updatedPlayingField, queries.tail)
    }
  }

  // Complete the arrayManipulation function below.
  def arrayManipulation(n: Int, queries: Array[Array[BigInt]]): BigInt = {
    val playingField = List.fill(n + 1)(BigInt(0))

    applyManipulations(playingField, queries)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nm = stdin.readLine.split(" ")

    val n = nm(0).trim.toInt
    val m = nm(1).trim.toInt

    val queries = Array.ofDim[BigInt](m, 3)

    for (i <- 0 until m) {
      queries(i) = stdin.readLine.split(" ").map(BigInt(_))
    }

    val result = arrayManipulation(n, queries)

    printWriter.println(result)

    printWriter.close()
  }
}

