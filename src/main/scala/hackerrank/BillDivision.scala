package hackerrank

import scala.io._

object BillDivision {

  def main(args: Array[String]): Unit = {
    val nk = StdIn.readLine().replaceAll("\\s+$", "").split(" ")

    val n = nk(0).toInt

    val k = nk(1).toInt

    val bill = StdIn.readLine().replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    val b = StdIn.readLine().trim.toInt

    bonAppetit(bill, k, b)
  }

  // Complete the bonAppetit function below.
  def bonAppetit(bill: Array[Int], k: Int, b: Int): Unit = {
    val actualBill = bill.sum - bill(k)

    if (b == actualBill / 2) println("Bon Appetit")
    else println(b - (actualBill / 2))

  }
}

