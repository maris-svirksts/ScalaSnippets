package hackerrank

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object CommonDivisors {
  def factorize(x: BigInt): List[BigInt] = {
    @tailrec
    def foo(x: BigInt, a: BigInt = 2, list: List[BigInt] = Nil): List[BigInt] = a * a > x match {
      case false if x % a == 0 => foo(x / a, a, a :: list)
      case false => foo(x, a + 1, list)
      case true => x :: list
    }

    foo(x)
  }

  def properDivisors(n: BigInt): List[BigInt] = {
    val factors = factorize(n)
    val products = (1 until factors.length).flatMap(i => factors.combinations(i).map(_.product).toList).toList
    (BigInt(1) :: n :: products).filter(_ <= n)
  }

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val testCases = readLine.trim.toInt

    for (i <- 1 to testCases) {
      val marioLuigi: Array[List[BigInt]] = readLine.trim.split(" ").map(x => properDivisors(BigInt(x)))
      val commonDivisors: List[BigInt]    = marioLuigi(0).intersect(marioLuigi(1))

      println(commonDivisors.length)
    }
  }
}
