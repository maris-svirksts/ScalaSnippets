package hackerrank.DaysOfCode

import scala.io.StdIn.readLine

object Day26NestedLogic {

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val returnedDate: Array[Int] = readLine().trim.split(" ").map(_.toInt)
    val dueDate:      Array[Int] = readLine().trim.split(" ").map(_.toInt)

    if(returnedDate(2) > dueDate(2)) println(10000)
    else if(returnedDate(1) > dueDate(1) &&
      returnedDate(2) == dueDate(2)
    ) println((returnedDate(1) - dueDate(1)) * 500)
    else if(returnedDate(0) > dueDate(0) &&
      returnedDate(2) == dueDate(2) &&
      returnedDate(1) == dueDate(1)
    ) println((returnedDate(0) - dueDate(0)) * 15)
    else println(0)
  }
}
