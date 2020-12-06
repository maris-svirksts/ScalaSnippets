package hackerrank

import scala.annotation.tailrec
import scala.io.StdIn

object SubsetSum {
  @tailrec
  def generalLoop(numbersToCheck: Seq[Long], listToCheck: List[Long], results: Map[Long, Int], accSum: Long, accLength: Int): Map[Long, Int] = {
    if(numbersToCheck.isEmpty || listToCheck.isEmpty) results
    else {
      if(numbersToCheck.head <= accSum) generalLoop(numbersToCheck.tail, listToCheck, results + (numbersToCheck.head -> accLength), accSum, accLength)
      else {
        val result = loop(numbersToCheck.head, listToCheck.tail, accSum + listToCheck.head, 1)
        if (result == -1) generalLoop(List(), List(), results, 0L, 0)
        else {
          val dividedList: (List[Long], List[Long]) = listToCheck.splitAt(result)
          val newAccSum: Long    = dividedList._1.sum + accSum
          val newAccLength: Int = dividedList._1.length + accLength
          generalLoop(numbersToCheck.tail, dividedList._2, results + (numbersToCheck.head -> (result + accLength)), newAccSum, newAccLength)
        }
      }
    }
  }

  @tailrec
  def loop(numberToCheck: Long, listToCheck: List[Long], currentSum: Long, counter: Int): Int = {
      if (currentSum >= numberToCheck) counter
      else if (listToCheck.isEmpty) -1
      else loop(numberToCheck, listToCheck.tail, currentSum + listToCheck.head, counter + 1)
  }

  def main(args: Array[String]) {
    val sizeOfList: String      = StdIn.readLine().trim // Not used.
    val listToCheck: List[Long] = StdIn.readLine().trim.split("\\s").map(_.toLong).sorted.reverse.toList
    val numberOfTestCases: Int  = StdIn.readLine().trim.toInt

    val numbersToCheck: Seq[Long] = for{
      i <- 0 until numberOfTestCases
      numberToCheck = StdIn.readLine().trim.toLong
    } yield numberToCheck

    val general = generalLoop(numbersToCheck.toList.sorted.distinct, listToCheck, Map(), 0L, 0)

    numbersToCheck.foreach(x => {
      println(general.getOrElse(x, -1))
    })
  }
}
