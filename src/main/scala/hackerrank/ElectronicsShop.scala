package hackerrank

import java.io.PrintWriter

object ElectronicsShop {

  /*
   * Complete the getMoneySpent function below.
   */
  def getMoneySpent(keyboards: Array[Int], drives: Array[Int], b: Int): Int = {
    /*
     * Write your code here.
     */
    val result: List[Int] = (for{
      i <- keyboards.indices
      j <- drives.indices
    } yield( keyboards(i) + drives(j) )).toSet.toList.sorted.reverse.filter(x => x <= b)

    if(result.isEmpty) -1
    else result.head
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val bnm = stdin.readLine().split(" ")

    val b = bnm(0).trim.toInt

    val n = bnm(1).trim.toInt

    val m = bnm(2).trim.toInt

    val keyboards = stdin.readLine().split(" ").map(_.trim.toInt)

    val drives = stdin.readLine().split(" ").map(_.trim.toInt)
    /*
     * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
     */

    val moneySpent = getMoneySpent(keyboards, drives, b)

    printWriter.println(moneySpent)

    printWriter.close()
  }
}

