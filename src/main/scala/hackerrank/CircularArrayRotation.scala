package hackerrank

// https://www.hackerrank.com/challenges/circular-array-rotation/problem

object CircularArrayRotation {

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn
    val nkq   = stdin.readLine().split(" ")

    val _ = nkq(0).trim.toInt
    val k = nkq(1).trim.toInt
    val q = nkq(2).trim.toInt
    val a = stdin.readLine().split(" ").map(_.trim.toInt)

    val queries: IndexedSeq[Int] = for {
      i <- 0 until q
    } yield stdin.readLine().trim.toInt

    val result = circularArrayRotation(a, k, queries)

    println(result.mkString("\n"))
  }

  // Complete the circularArrayRotation function below.
  def circularArrayRotation(a: IndexedSeq[Int], k: Int, queries: IndexedSeq[Int]): IndexedSeq[Int] = {
    val rotatedElements: List[Int] = a.toList.indices.map(x => {
      val shift: Int = a.length - (k % a.length)
      val index: Int = (shift + x) % a.length

      a(index)
    }).toList

    val result = queries.map(y => rotatedElements(y))

    result
  }
}

