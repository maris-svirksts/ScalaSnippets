package hackerrank.Nutanix

import scala.annotation.tailrec

/**
 * https://web.stanford.edu/class/cs9/sample_probs/TwoSum.pdf, Option 4: Sorting and Walking Inward
 */
object HashTablesIceCreamParlor {

  // Complete the whatFlavors function below.
  def whatFlavors(cost: Array[Int], money: Int): List[Int] = {
    val options = cost.filter(_ < money).sorted

    @tailrec
    def sortAndWalkInward(lowerCounter: Int, upperCounter: Int): List[Int] = {
      if(lowerCounter >= upperCounter) -1 :: -1 :: Nil
      else {
        val sum = options(lowerCounter) + options(upperCounter)

        if (sum == money) cost.indexOf(options(lowerCounter)) + 1 :: cost.lastIndexOf(options(upperCounter)) + 1 :: Nil
        else if (sum > money) sortAndWalkInward(lowerCounter, upperCounter - 1)
        else sortAndWalkInward(lowerCounter + 1, upperCounter)
      }
    }

    sortAndWalkInward(0, options.length - 1).sorted
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val t = stdin.readLine.trim.toInt

    for (_ <- 1 to t) {
      val money = stdin.readLine.trim.toInt
      val _     = stdin.readLine.trim.toInt
      val cost  = stdin.readLine.split(" ").map(_.trim.toInt)

      val results = whatFlavors(cost, money).mkString(" ")

      println(results)
    }
  }
}
