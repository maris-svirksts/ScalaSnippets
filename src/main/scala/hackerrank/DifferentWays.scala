package hackerrank

// https://www.hackerrank.com/challenges/different-ways-fp/problem

import scala.io.StdIn.readLine

object DifferentWays {
  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val numberOfTestCases: Int = readLine().trim.toInt
    val modulo:            Int = math.pow(10, 8).toInt + 7

    lazy val stream: LazyList[BigInt] = BigInt(1) #:: BigInt(1) #:: stream.zipWithIndex.tail.map{case (f, i) => f * i}
    val source                 = stream.drop(1)

    for {
      _ <- 1 to numberOfTestCases
      variables = readLine().trim.split(" ").map(_.toInt)
    } yield println(source(variables(0))/(source(variables(1)) * source(variables(0) - variables(1))) % modulo)
  }
}
