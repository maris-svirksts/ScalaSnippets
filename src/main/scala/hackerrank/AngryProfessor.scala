package hackerrank

import java.io._

object AngryProfessor {

  // Complete the angryProfessor function below.
  def angryProfessor(k: Int, a: Array[Int]): String = {
    if(a.count(_ <= 0) < k) "YES"
    else "NO"
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val nk = stdin.readLine.split(" ")
      val k  = nk(1).trim.toInt

      val a      = stdin.readLine.split(" ").map(_.trim.toInt)
      val result = angryProfessor(k, a)

      printWriter.println(result)
    }

    printWriter.close()
  }
}

