package hackerrank

import java.io._
import scala.io._

object MigratoryBirds {

  // Complete the migratoryBirds function below.
  def migratoryBirds(arr: Array[Int]): Int = {
    val grouped: List[(Int, List[Int])] = arr.toList.groupBy(x => x).toList.sortBy(x => { x._2.length })
    val filter: List[(Int, List[Int])] = grouped.filter(x => {x._2.length == grouped.lastOption.get._2.length}).sortBy(x => { x._1 })

    filter.headOption.get._1
  }

  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val arrCount = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    val result = migratoryBirds(arr)

    printWriter.println(result)

    printWriter.close()
  }
}

