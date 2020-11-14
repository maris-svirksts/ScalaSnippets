package hackerrank

import java.io._

import scala.annotation.tailrec

object BreakingTheRecords {

  // Complete the breakingRecords function below.
  def breakingRecords(scores: Array[Int]): Array[Int] = {

    @tailrec
    def loop(scores: Array[Int], highScore: List[Int], lowScore: List[Int]): Array[Int] = {
      if(scores.isEmpty) Array(highScore.length - 1, lowScore.length - 1)
      else if (scores.head > highScore.max) loop(scores.tail, scores.head :: highScore, lowScore)
      else if (scores.head < lowScore.min) loop(scores.tail, highScore, scores.head :: lowScore)
      else loop(scores.tail, highScore, lowScore)
    }

    loop(scores.tail, List(scores.head), List(scores.head))
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val scores = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = breakingRecords(scores)

    printWriter.println(result.mkString(" "))

    printWriter.close()
  }
}
