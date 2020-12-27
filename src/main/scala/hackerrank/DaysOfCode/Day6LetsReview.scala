package hackerrank.DaysOfCode

import scala.io.StdIn.readLine

object Day6LetsReview {

  def main(args: Array[String]): Unit = {
    val counter: Int = readLine().trim.toInt

    for(_ <- 1 to counter) {
      val initialString: String = readLine().trim

      val evenIndices: String = initialString.indices.filter(x => x % 2 == 0).map(y => initialString(y)).mkString
      val oddIndices:  String = initialString.indices.filter(x => x % 2 == 1).map(y => initialString(y)).mkString

      println(s"$evenIndices $oddIndices")
    }
  }
}
