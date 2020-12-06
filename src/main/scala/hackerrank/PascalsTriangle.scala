package hackerrank

import scala.annotation.tailrec
import scala.io.StdIn

object PascalsTriangle {

  @tailrec
  def loop(rows: Int, resultList: List[List[Int]]): List[List[Int]] = {
    if(rows <= 2) resultList
    else{
      val nextLine: List[Int] = 1 +: resultList.head.sliding(2, 1).map(x => x.sum) .toList :+ 1
      loop(rows - 1, nextLine :: resultList)
    }
  }

  def main(args: Array[String]) {
    val rows = StdIn.readLine().trim.toInt

    val results: List[List[Int]] = loop(rows, List(List(1, 1), List(1)))

    results.reverse.foreach(x => println(x.mkString(" ")))
  }
}
