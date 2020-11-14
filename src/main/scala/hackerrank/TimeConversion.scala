package hackerrank

import java.io.PrintWriter
import java.text.SimpleDateFormat

object TimeConversion {

  /*
   * Complete the timeConversion function below.
   */
  def timeConversion(s: String): String = {
    val twelveHourFormat = new java.text.SimpleDateFormat("h:mm:ssa")
    val twelveHourTime   = twelveHourFormat.parse(s)

    val formatter = new SimpleDateFormat("HH:mm:ss")
    formatter.format(twelveHourTime)
  }

  def main(args: Array[String]): Unit = {
    val scan = scala.io.StdIn

    val fw = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = scan.readLine

    val result = timeConversion(s)

    fw.println(result)

    fw.close()
  }
}

