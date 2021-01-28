package hackerrank

import scala.io._

object Result {
  def rotateLeft(d: Int, arr: Array[Int]): List[Int] = {
    val rotatedElements: List[Int] = arr.toList.indices.map(x => {
      val shift: Int = d % arr.length
      val index: Int = (shift + x) % arr.length

      arr(index)
    }).toList

    rotatedElements
  }
}

object LeftRotation {
  def main(args: Array[String]): Unit = {

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val _   = firstMultipleInput(0).toInt
    val d   = firstMultipleInput(1).toInt
    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.rotateLeft(d, arr)

    println(result.mkString(" "))
  }
}

