package hackerrank

import java.io._

object SaveThePrisoner {

  // Complete the saveThePrisoner function below.
  def saveThePrisoner(n: BigInt, m: BigInt, s: BigInt): BigInt = {
    (s - 1 + m- 1) % n + 1
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val t = stdin.readLine.trim.toInt

    for (_ <- 1 to t) {
      val nms = stdin.readLine.split(" ").map(x => BigInt(x.trim))

      val n = nms(0)
      val m = nms(1)
      val s = nms(2)

      val result = saveThePrisoner(n, m, s)

      printWriter.println(result)
    }

    printWriter.close()
  }
}

