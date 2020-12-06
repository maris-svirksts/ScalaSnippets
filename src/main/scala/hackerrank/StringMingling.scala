package hackerrank

import scala.io.StdIn

object StringMingling {

  def main(args: Array[String]) {
    val firstString: String  = StdIn.readLine().trim
    val secondString: String = StdIn.readLine().trim

    val results: Seq[String] = for{
      i <- firstString.indices
    } yield s"${firstString(i)}${secondString(i)}"

    println(results.mkString(""))
  }
}
