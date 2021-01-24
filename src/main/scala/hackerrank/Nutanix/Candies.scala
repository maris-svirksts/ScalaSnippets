package hackerrank.Nutanix

import scala.annotation.tailrec

object Candies {
  @tailrec
  def calculateCandyPerKid(kids: List[Int], previousChild: Int, previousSweet: Int, flow: Int, sum: Long): Long = {
    if(kids.isEmpty) if(flow >= previousSweet) sum + 1 + flow - previousSweet else sum
    else {
      if(kids.head >= previousChild) {
        val tempSum = if(flow > 0)
          if (flow >= previousSweet) sum + 1 + flow - previousSweet else sum
        else
          sum

        val tempPreviousSweet = if(flow > 0) 1 else previousSweet
        val newFlow           = if(flow > 0) 0 else flow

        val newPreviousSweet  = if(kids.head > previousChild) tempPreviousSweet + 1 else 1

        calculateCandyPerKid(kids.tail, kids.head, newPreviousSweet, newFlow, newPreviousSweet + tempSum)
      }
      else calculateCandyPerKid(kids.tail, kids.head, previousSweet, flow + 1, sum + flow + 1)
    }
  }

  // Complete the candies function below.
  def candies(children: List[Int]): Long = {
    calculateCandyPerKid(children, 0, 0, 0, 0L)
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn
    val n     = stdin.readLine.trim.toInt

    val children = (for {
      _ <- 0 until n
    } yield stdin.readLine.trim.toInt).toList

    val result = candies(children)

    println(result)
  }
}

