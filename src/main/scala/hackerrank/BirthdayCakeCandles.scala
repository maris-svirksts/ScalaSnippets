package hackerrank

import java.io._

import scala.io._

object BirthdayCakeCandlesResult {

  /*
   * Complete the 'birthdayCakeCandles' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY candles as parameter.
   */

  def birthdayCakeCandles(candles: Array[Int]): Int = {
    val highestCandle = candles.max

    val result = for{
      i <- candles.indices
      if candles(i) == highestCandle
    } yield i

    result.length
  }

}

object BirthdayCakeCandles {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val candlesCount = StdIn.readLine().trim.toInt

    val candles = StdIn.readLine().replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = BirthdayCakeCandlesResult.birthdayCakeCandles(candles)

    printWriter.println(result)

    printWriter.close()
  }
}