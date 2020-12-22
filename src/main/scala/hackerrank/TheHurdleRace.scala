package hackerrank

import java.io._

object TheHurdleRace {

  // Complete the hurdleRace function below.
  def hurdleRace(k: Int, height: Array[Int]): Int = {
    height.map(x => if(x - k < 0) 0 else x - k).max
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nk = stdin.readLine.split(" ")
    val k  = nk(1).trim.toInt

    val height = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = hurdleRace(k, height)

    printWriter.println(result)

    printWriter.close()
  }
}

