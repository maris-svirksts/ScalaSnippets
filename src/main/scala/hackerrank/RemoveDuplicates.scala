package hackerrank

import scala.collection.mutable
import scala.io.StdIn

// There is another task on hackerrank that boils down to the same input/output: StringReductions
object RemoveDuplicates {

  def main(args: Array[String]): Unit = {
    val inputString: Seq[Char] = StdIn.readLine().trim.toSeq
    val itsSorted: String      = mutable.LinkedHashSet(inputString: _*).mkString("")

    println(itsSorted)
  }
}
