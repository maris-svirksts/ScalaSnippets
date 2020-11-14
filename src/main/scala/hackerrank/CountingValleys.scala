package hackerrank

import java.io._

import scala.annotation.tailrec
import scala.io._

object ResultCountingValleys {

  /*
   * Complete the 'countingValleys' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER steps
   *  2. STRING path
   */

  def countingValleys(steps: Int, path: String): Int = {
    val pathList: List[Char] = path.toList

    @tailrec
    def loop(path: List[Char], valleys: Int, currentElevation: Int): Int = {
      if (path.isEmpty) valleys
      else if(path.headOption.getOrElse("") == 'D' && currentElevation == 0) loop(path.tail, valleys + 1, currentElevation - 1)
      else if(path.headOption.getOrElse("") == 'U') loop(path.tail, valleys, currentElevation + 1)
      else if(path.headOption.getOrElse("") == 'D') loop(path.tail, valleys, currentElevation - 1)
      else loop(path.tail, valleys, currentElevation)
    }

    loop(pathList, 0, 0)
  }

}

object CountingValleys {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val steps = StdIn.readLine().trim.toInt

    val path = StdIn.readLine()

    val result = ResultCountingValleys.countingValleys(steps, path)

    printWriter.println(result)

    printWriter.close()
  }
}
