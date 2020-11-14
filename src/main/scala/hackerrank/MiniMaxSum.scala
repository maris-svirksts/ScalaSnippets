package hackerrank

object MiniMaxSum {

  // Complete the miniMaxSum function below.
  def miniMaxSum(arr: Array[Long]): Unit = {
    val maximum: Long = arr.sorted.tail.sum
    val minimum: Long = arr.sorted.init.sum

    println(minimum + " " + maximum)
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val arr = stdin.readLine.split(" ").map(_.trim.toLong)
    miniMaxSum(arr)
  }
}
