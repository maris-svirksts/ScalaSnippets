package hackerrank

// https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

object TwoStrings {

  // Complete the twoStrings function below.
  def twoStrings(s1: String, s2: String): String = {
    if(s1.toSeq.distinct.intersect(s2.toSeq.distinct).nonEmpty) "YES" else "NO"
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val q = stdin.readLine.trim.toInt

    for (_ <- 1 to q) {
      val s1 = stdin.readLine
      val s2 = stdin.readLine

      val result = twoStrings(s1, s2)
      println(result)
    }
  }
}

