package hackerrank.DaysOfCode

import scala.io.StdIn

object Day8DictionariesAndMaps {
  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val phoneBook: Map[String, String] = (for {
      _ <- 1 to StdIn.readLine().trim.toInt
      Array(name, value) = StdIn.readLine().trim.split(" ")
    } yield name -> value).toMap

    Iterator.continually(StdIn.readLine()).
      takeWhile(line => line != null).
      map(x => {
        phoneBook.getOrElse(x, "") match {
          case a if a.isEmpty => "Not found"
          case a => s"$x=$a"
        }
      }).foreach(println(_))
  }
}
