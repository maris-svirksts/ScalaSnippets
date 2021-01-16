package hackerrank.DaysOfCode

import scala.io.StdIn.readLine

object Day25RunningTimeAndComplexity {
  def isPrime(element: Long): String = {
    if(element == 2L || element == 3L) "Prime"
    else if(element <= 1L || element % 2 == 0 || element % 3 == 0) "Not prime"
    else {
      val checkTill: Long = math.sqrt(element).ceil.toInt + 1

      if(List.range(5L, checkTill, 2L).forall(x => element % x != 0)) "Prime"
      else "Not prime"
    }
  }

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val numberOfTestCases: Int = readLine().trim.toInt

    for {
      _ <- 1 to numberOfTestCases
    } yield println(isPrime(readLine().trim.toLong))
  }
}
