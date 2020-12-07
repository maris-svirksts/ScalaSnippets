package hackerrank

import scala.io.StdIn

object SubstringSearching {

  def main(args: Array[String]): Unit = {
    val numberOfLines: Int  = StdIn.readLine().trim.toInt

    val results = for{
      _ <- 0 until numberOfLines
      hayStack = StdIn.readLine().trim
      needle   = StdIn.readLine().trim
    } yield hayStack.toCharArray.containsSlice(needle)

    results.foreach( x => {
      if(x) println("YES") else println("NO")
    })
  }
}
