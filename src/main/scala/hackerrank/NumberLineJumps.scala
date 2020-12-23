package hackerrank

import java.io._
import scala.annotation.tailrec

object NumberLineJumps {

  // Complete the kangaroo function below.
  def kangaroo(startK1: Int, jumpK1: Int, startK2: Int, jumpK2: Int): String = {

    @tailrec
    def kangarooLoop(startK1: Int, jumpK1: Int, startK2: Int, jumpK2: Int): String = {
      if(startK1 > startK2) "NO"
      else if(startK1 == startK2) "YES"
      else kangarooLoop(startK1 + jumpK1, jumpK1, startK2 + jumpK2, jumpK2)
    }

    if(jumpK2 >= jumpK1) "NO"
    else kangarooLoop(startK1 + jumpK1, jumpK1, startK2 + jumpK2, jumpK2)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val x1V1X2V2 = stdin.readLine().split(" ")
    val x1 = x1V1X2V2(0).trim.toInt
    val v1 = x1V1X2V2(1).trim.toInt
    val x2 = x1V1X2V2(2).trim.toInt
    val v2 = x1V1X2V2(3).trim.toInt

    val result = kangaroo(x1, v1, x2, v2)

    printWriter.println(result)
    printWriter.close()
  }
}

