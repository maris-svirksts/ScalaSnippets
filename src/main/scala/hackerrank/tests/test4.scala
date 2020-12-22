package hackerrank.tests

import java.io._
import scala.io._



object test4 {

  /*
   * Complete the 'possibleChanges' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts STRING_ARRAY usernames as parameter.
   */

  def possibleChanges(usernames: Array[String]): Array[String] = {
    usernames.map(x => {
      val sortedVersion = x.toSeq.sorted.toString
      if (sortedVersion == x) "NO"
      else "YES"
    })
  }

  object test4Solution {
    def main(args: Array[String]) {
      val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

      val usernamesCount = StdIn.readLine.trim.toInt

      val usernames = Array.ofDim[String](usernamesCount)

      for (i <- 0 until usernamesCount) {
        val usernamesItem = StdIn.readLine
        usernames(i) = usernamesItem
      }

      val result = test4.possibleChanges(usernames)

      printWriter.println(result.mkString("\n"))

      printWriter.close()
    }
  }
}
