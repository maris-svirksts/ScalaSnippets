package hackerrank

import java.io._

object CircularArrayRotation {

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nkq = stdin.readLine().split(" ")

    val n = nkq(0).trim.toInt

    val k = nkq(1).trim.toInt

    val q = nkq(2).trim.toInt

    val a = stdin.readLine().split(" ").map(_.trim.toInt)

    val queries = Array.ofDim[Int](q)

    for (i <- 0 until q) {
      val queriesItem = stdin.readLine().trim.toInt
      queries(i) = queriesItem
    }

    val result = circularArrayRotation(a, k, queries)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }

  // Complete the circularArrayRotation function below.
  def circularArrayRotation(a: Array[Int], k: Int, queries: Array[Int]): Array[Int] = {
    println("a: " + a.toList)
    val rotatedElements: List[Int] = a.toList.indices.map(x => {
      val shift: Int = a.length - (k % a.length)
      val index: Int = (shift + x) % a.length

      a(index)
    }).toList

    val result = queries.map(y => rotatedElements(y))

    result
  }
}

