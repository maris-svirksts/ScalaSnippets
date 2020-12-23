package hackerrank

import java.io.PrintWriter

object DrawingBook {

  /*
   * Complete the pageCount function below.
   */
  def pageCount(n: Long, p: Long): Long = {
    /*
     * Write your code here.
     */
    val fromBeginning: Long = p / 2
    val fromEnd: Long = (n - p) / 2

    if(fromBeginning < fromEnd) fromBeginning
    else{ // Hacky.
      if(n % 2 == 0 && n - p == 1 && fromBeginning > fromEnd + 1) fromEnd + 1 else fromEnd
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine().trim.toInt

    val p = stdin.readLine().trim.toInt

    val result = pageCount(n, p)

    printWriter.println(result)

    printWriter.close()
  }
}