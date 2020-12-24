package hackerrank

import scala.io.StdIn

object MissingNumbers {

  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val firstCount: Int        = StdIn.readLine().toInt
    val firstLine: Array[Int]  = StdIn.readLine().split(" ").map(_.toInt)
    val secondCount: Int       = StdIn.readLine().toInt
    val secondLine: Array[Int] = StdIn.readLine().split(" ").map(_.toInt)

    val difference: Array[Int] = secondLine.diff(firstLine).distinct.sorted

    println(difference.mkString(" "))
  }
}