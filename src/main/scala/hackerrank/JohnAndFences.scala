package hackerrank

// https://www.hackerrank.com/challenges/john-and-fences/problem and https://www.hackerrank.com/challenges/largest-rectangle/problem

import scala.io.StdIn.readLine

object JohnAndFences {

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val arrayLength       = readLine().trim.toInt
    val fence: Array[Int] = readLine().trim.split(" ").map(_.toInt)

    val sums = fence.indices.map(x => checkLength(x, fence, arrayLength))

    println(sums.max)
  }

  def checkLength(position: Int, fence: Array[Int], arrayLength: Int): Int = {
    def before(index: Int): Int = {
      if(index >= 0 && fence(index) >= fence(position)) fence(position) + before(index - 1) else 0
    }

    def after(index: Int): Int = {
      if(index < arrayLength && fence(index) >= fence(position)) fence(position) + after(index + 1) else 0
    }

    before(position - 1) + after(position + 1) + fence(position)
  }
}
