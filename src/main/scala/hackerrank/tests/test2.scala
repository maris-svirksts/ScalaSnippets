package hackerrank.tests

import java.io.PrintWriter

import scala.io.StdIn


object ResultTest2 {

  /*
   * Complete the 'findSubstring' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. INTEGER k
   */

  def findSubstring(s: String, k: Int): String = {
      val vowels: List[String] = List("a", "e", "i", "i", "u")
      val sToSlider: List[String] = s.toSeq.sliding(5, 1).map(_.unwrap).toList

      val intersectCounts: Map[String, Int] = vowels.intersect(sToSlider).map(s => s -> sToSlider.count(_ == s)).toMap

      val results: Seq[Int] = vowels.map(intersectCounts.getOrElse(_, 0))
      val maximum: Int = results.max

      val result: Seq[Int] = for {
        i <- results.indices
        if results(i) == maximum
      } yield i

    if( result.isEmpty ) {
      "None"
    }
    else {
      sToSlider(result.head)
    }
  }

}

object SolutionTest2 {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = StdIn.readLine

    val k = StdIn.readLine.trim.toInt

    val result = ResultTest2.findSubstring(s, k)

    printWriter.println(result)

    printWriter.close()
  }
}

