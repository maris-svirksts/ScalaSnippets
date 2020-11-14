package hackerrank

import java.io.PrintWriter

import scala.annotation.tailrec
import scala.io.StdIn

object BetweenTwoSetsResult {

  /*
   * Complete the 'getTotalX' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY a
   *  2. INTEGER_ARRAY b
   */

  def getTotalX(firstArray: Array[Int], secondArray: Array[Int]): Int = {

    @tailrec
    def gcd(a: Int, b: Int): Int = {
      if (0 == a && 0 == b) -1
      else if (0 == b) Math.abs(a)
      else if (0 == a) Math.abs(b)
      else gcd(b, a % b)
    }

    @tailrec
    def commonDivisorCalc(a: Int, divisorList: List[Int], currentPretender: Int): List[Int] = {
      if(currentPretender > a / 2) divisorList
      else if(a % currentPretender == 0) commonDivisorCalc(a, currentPretender +: divisorList, currentPretender + 1)
      else commonDivisorCalc(a, divisorList, currentPretender + 1)
    }

    @tailrec
    def numbersBetweenCalc( commonDivisors: List[Int], results: List[Int] ): List[Int] = {
      if(commonDivisors.isEmpty) results
      else if(firstArray.forall(x => {commonDivisors.head % x == 0})) {
        numbersBetweenCalc(commonDivisors.tail, commonDivisors.head +: results)
      }
      else numbersBetweenCalc(commonDivisors.tail, results)
    }

    val greatestCommonDivisors: List[Int] = secondArray.sliding(2, 1).map(f = x => { gcd(x.headOption.getOrElse(0), x.tail.headOption.getOrElse(0)) }).toList
    val commonDivisors: List[Int] = greatestCommonDivisors.map(x => commonDivisorCalc(x, List(x), 1)).reduce((x, y) => x.intersect(y))
    val numbersBetween: List[Int] = numbersBetweenCalc(commonDivisors, List())

    numbersBetween.length
  }

}

object BetweenTwoSets {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")
    val n = firstMultipleInput(0).toInt
    val m = firstMultipleInput(1).toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    val brr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val total = BetweenTwoSetsResult.getTotalX(arr, brr)

    printWriter.println(total)
    printWriter.close()
  }
}