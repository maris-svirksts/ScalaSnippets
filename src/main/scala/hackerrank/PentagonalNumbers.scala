package hackerrank

import scala.io.StdIn

object PentagonalNumbers {

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val numberOfLines = StdIn.readLine().trim.toInt

    for( _ <- 0 until numberOfLines ){
      val element = StdIn.readLine().trim.toLong
      println((3 * element * element - element) / 2)
    }
  }
}
