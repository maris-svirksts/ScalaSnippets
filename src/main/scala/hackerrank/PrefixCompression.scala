package hackerrank

import scala.annotation.tailrec
import scala.io.StdIn

object PrefixCompression {
  @tailrec
  def loop(firstString: String, secondString: String, sharedData: List[Char]): List[String] = {
    if(firstString.isEmpty || secondString.isEmpty || firstString.head != secondString.head) List(sharedData.reverse.mkString(""), firstString, secondString)
    else loop(firstString.tail, secondString.tail, firstString.head :: sharedData)
  }

  def main(args: Array[String]): Unit = {
    val firstString: String  = StdIn.readLine().trim
    val secondString: String = StdIn.readLine().trim

    val results = loop(firstString, secondString, List())

    results.foreach(x => println(s"${x.length} $x"))
  }
}
