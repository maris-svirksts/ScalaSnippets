package hackerrank

import java.io._

object FindDigits {

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val t = stdin.readLine().trim.toInt

    for (tItr <- 1 to t) {
      val n = stdin.readLine().trim.toInt

      val result = findDigits(n)

      printWriter.println(result)
    }

    printWriter.close()
  }

  // Complete the findDigits function below.
  def findDigits(n: Int): Int = {
    val digitList: List[Int] = n.toString.toList.map(_.asDigit)

    val filter = digitList.filter(x => x != 0 && n % x == 0)

    filter.size
  }
}

