package hackerrank

import java.io._

object EqualizeTheArray {

  // Complete the equalizeArray function below.
  def equalizeArray(arr: Array[Int]): Int = {
    val findMaximum = arr.groupBy(identity).map(x => x._2.length)

    arr.length - findMaximum.max
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = equalizeArray(arr)

    printWriter.println(result)

    printWriter.close()
  }
}


