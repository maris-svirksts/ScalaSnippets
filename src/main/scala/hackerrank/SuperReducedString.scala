package hackerrank

import java.io._
import scala.io._

object SuperReducedString {

  // Complete the superReducedString function below.
  def superReducedString(s: String): String = {
    val result = s.foldLeft("")((left, right) => {
      if (left.lastOption.getOrElse("") != right) left :+ right
      else left.init
    })

    if(result.isEmpty) "Empty String"
    else result
  }

  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s      = StdIn.readLine
    val result = superReducedString(s)

    printWriter.println(result)

    printWriter.close()
  }
}
