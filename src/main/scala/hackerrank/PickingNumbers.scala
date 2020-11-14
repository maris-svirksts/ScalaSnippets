package hackerrank

import java.io._
import scala.io._

object PickingNumbersResult {

  /*
   * Complete the 'pickingNumbers' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  def pickingNumbers(a: Array[Int]): Int = {
    val sortedGroupedA: List[(Int, List[Int])] = a.toList.groupBy(x => x).toList.sortBy(_._1)
    if(sortedGroupedA.size > 1) {

      val slided: List[List[(Int, List[Int])]] = sortedGroupedA.sliding(2, 1).toList

      val map: List[Int] = slided.map(x => {
        val difference = math.abs(x.headOption.get._1 - x.lastOption.get._1)
        val headLength = x.headOption.get._2.length
        val lastLength = x.lastOption.get._2.length
        if (difference < 2) x.headOption.get._2.length + x.lastOption.get._2.length
        else if( headLength > lastLength ) headLength
        else lastLength
      })

      println("sortedGroupedA: " + sortedGroupedA)
      println("slided: " + slided)
      println("map: " + map)

      map.sorted.reverse.headOption.getOrElse(0)
    }
    else sortedGroupedA.headOption.get._2.length
  }

}

object PickingNumbers {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine().trim.toInt

    val a = StdIn.readLine().replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = PickingNumbersResult.pickingNumbers(a)

    printWriter.println(result)

    printWriter.close()
  }
}