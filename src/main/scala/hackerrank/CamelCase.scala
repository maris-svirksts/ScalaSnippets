package hackerrank

import java.io._

object CamelCase {

  // Complete the camelcase function below.
  def camelCase(s: String): Int = {
    s.count(_.isUpper) + 1
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
    val s           = stdin.readLine
    val result      = camelCase(s)

    printWriter.println(result)

    printWriter.close()
  }
}

