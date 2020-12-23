package hackerrank

import java.io._
import scala.annotation.tailrec

object CutTheSticks {

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine().trim.toInt

    val arr = stdin.readLine().split(" ").map(_.trim.toInt)
    val result = cutTheSticks(arr)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }

  // Complete the cutTheSticks function below.
  def cutTheSticks(arr: Array[Int]): List[Int] = {
    @tailrec
    def loop(sticks: Array[Int], count: List[Int]): List[Int] = {
      if (sticks.distinct.length < 2) count.reverse
      else {
        val minStick: Int = sticks.min
        val cutSticks: Array[Int] = sticks.map(_ - minStick).filter(_ > 0)
        loop(cutSticks, cutSticks.length :: count)
      }
    }

    loop(arr, List(arr.length))
  }
}

