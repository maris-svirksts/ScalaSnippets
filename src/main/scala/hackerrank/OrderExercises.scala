package hackerrank

import scala.annotation.tailrec

object Solution {

  def main(args: Array[String]): Unit = {
    val read = scala.io.StdIn
    val temp = read.readLine().split(" ")
    val maxReturn = temp(1).toInt
    val elements: Array[Int] = read.readLine().split(" ").map(_.toInt)

    @tailrec
    def loop(remainingElements: Array[Int], index: Int, positiveElements: List[Int], results: List[(Int, List[Int])], iterationId: Int): List[(Int, List[Int])] = {
      if (remainingElements.isEmpty) results
      else if (remainingElements.head <= 0) {
        if (index >= 0) loop(remainingElements.tail, -1, List(), (index, positiveElements) :: results, iterationId + 1)
        else loop(remainingElements.tail, -1, List(), results, iterationId + 1)
      }
      else if (index < 0) loop(remainingElements.tail, iterationId, List(remainingElements.head), results, iterationId + 1)
      else loop(remainingElements.tail, index, remainingElements.head :: positiveElements, results, iterationId + 1)
    }

    val results: List[(Int, List[Int])] = loop(elements, -1, List(), List(), 0).sortWith(_._2.sum > _._2.sum).take(maxReturn)

    results.foreach(x => println(x._2.sum))
  }
}