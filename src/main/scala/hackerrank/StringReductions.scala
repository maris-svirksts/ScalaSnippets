package hackerrank

import scala.collection.mutable
import scala.io.StdIn

object StringReductions {

  def main(args: Array[String]): Unit = {
    val inputString: Seq[Char] = StdIn.readLine().trim.toSeq
    val itsSorted: String      = mutable.LinkedHashSet(inputString: _*).mkString("")

    println(itsSorted)
  }
}
