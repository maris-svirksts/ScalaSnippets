package hackerrank.Nutanix

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

/**
 * There already is a decent solution: https://stackoverflow.com/questions/14226252/scala-code-bubble-sort-for-loop/20806394
 * Here is an alternative solution.
 */
object SortingBubbleSort {

  // Complete the countSwaps function below.
  def countSwaps(a: Array[Int]): (Int, List[Int]) = {
    @tailrec
    def loop(counter: Int, old: ArrayBuffer[Int], updated: List[Int]): (Int, List[Int]) = {
      if(old.isEmpty) (counter, updated)
      else {
        val max    = old.max
        val index  = old.indexOf(max)
        val length = old.length

        old.remove(index)
        old.trimToSize()
        loop(counter + (length - index - 1), old, max :: updated)
      }
    }

    loop(0, a.to(ArrayBuffer), List())
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n     = stdin.readLine.trim.toInt
    val a     = stdin.readLine.split(" ").map(_.trim.toInt)

    val _@(swaps, elements) = countSwaps(a)

    println(s"Array is sorted in $swaps swaps.")
    println(s"First Element: ${elements.headOption.getOrElse(0)}")
    println(s"Last Element: ${elements.lastOption.getOrElse(0)}")
  }
}

