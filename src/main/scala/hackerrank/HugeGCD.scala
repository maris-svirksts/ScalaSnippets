package hackerrank

import scala.annotation.tailrec
import scala.io.StdIn

//BigInt was instrumental in getting this to work.
object HugeGCD {
  @tailrec
  def gcd(a: BigInt, b: BigInt): BigInt = {
    if (0 == a && 0 == b) -1
    else if (0 == b) a
    else if (0 == a) b
    else gcd(b, a % b)
  }

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val _         = StdIn.readLine()
    val firstList = StdIn.readLine().trim.split(" ").map(BigInt(_)).toList

    val _          = StdIn.readLine()
    val secondList = StdIn.readLine().trim.split(" ").map(BigInt(_)).toList

    val identicalElements: List[BigInt] = firstList.intersect(secondList)
    val power: BigInt                   = BigInt(Math.pow(10, 9).toInt)

    println(
      (
        (gcd(
          firstList.diff(identicalElements).product,
          secondList.diff(identicalElements).product
        ) * identicalElements.product) % (power + 7)
      ).toInt
    )
  }
}
