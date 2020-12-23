package hackerrank

import java.io._


object RepeatedString {

  // Complete the repeatedString function below.
  def repeatedString(s: String, n: Long): Long = {
    val initialACount: Int = s.count(_ == 'a')
    val fullStrings: Long  = n / s.length
    val partialString: Int = (n % s.length).toInt
    val AInPartial: Int    = s.take(partialString).count(_ == 'a')

    (initialACount * fullStrings) + AInPartial
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = stdin.readLine

    val n = stdin.readLine.trim.toLong

    val result = repeatedString(s, n)

    printWriter.println(result)

    printWriter.close()
  }
}

