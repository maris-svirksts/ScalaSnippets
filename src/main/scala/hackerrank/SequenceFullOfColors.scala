package hackerrank

import scala.annotation.tailrec
import scala.io.StdIn

// Changing to List[Char] allows for much faster actions compared to leaving as String on input.

object SequenceFullOfColors {
  @tailrec
  def loop(input: List[Char], counterMap: Map[Char, Int]): String = {
    if(math.abs(counterMap.getOrElse('R', 0) - counterMap.getOrElse('G', 0)) > 1) "False"
    else if(math.abs(counterMap.getOrElse('Y', 0) - counterMap.getOrElse('B', 0)) > 1) "False"
    else if(input.isEmpty) {
      if(
        counterMap.getOrElse('R', 0) == counterMap.getOrElse('G', 0) &&
        counterMap.getOrElse('Y', 0) == counterMap.getOrElse('B', 0)
      ) "True"
      else "False"
    }
    else {
      val numberToIncrease = counterMap.getOrElse(input.head, 0) + 1
      val updatedMap       = counterMap + (input.head -> numberToIncrease)

      loop(input.tail, updatedMap)
    }
  }

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val numberOfLines = StdIn.readLine().trim.toInt

    for( _ <- 0 until numberOfLines ){
      val element = StdIn.readLine().trim

      println(loop(element.toList, Map()))
    }
  }
}
