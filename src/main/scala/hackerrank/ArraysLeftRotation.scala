package hackerrank

// https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

object ArraysLeftRotation {

  // Complete the rotLeft function below.
  def rotLeft(a: Array[Int], d: Int): List[Int] = {
    val rotatedElements: List[Int] = a.toList.indices.map(x => {
      val shift: Int = d % a.length
      val index: Int = (shift + x) % a.length

      a(index)
    }).toList

    rotatedElements
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val nd    = stdin.readLine.split(" ")

    val _      = nd(0).trim.toInt
    val d      = nd(1).trim.toInt
    val a      = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = rotLeft(a, d)

    println(result.mkString(" "))
  }
}

