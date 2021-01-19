package hackerrank.DaysOfCode

import scala.io.StdIn.readLine

object Day29BitwiseAND {
  def main(args: Array[String]) {
    val t = readLine.trim.toInt

    for (_ <- 1 to t) {
      val nk = readLine.split(" ")

      val n = nk(0).trim.toInt
      val k = nk(1).trim.toInt

      //val version1 = List.range(1, n + 1).combinations(2).map(x => x(0) & x(1)).filter(y => y < k).max
      val bitOr = (k - 1) | k
      val version2 = if(bitOr <= n) k - 1 else k - 2

      println(version2)
    }
  }
}

