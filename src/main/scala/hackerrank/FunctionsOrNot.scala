package hackerrank

object FunctionsOrNot {

  def main(args: Array[String]): Unit = {
    val resultList: List[Int] = (0 until scala.io.StdIn.readLine().toInt).toList
    resultList.foreach(
      x => {
        val testCaseCount: List[Int] = (0 until scala.io.StdIn.readLine().toInt).toList
        val testCases: List[(Int, Int)] = testCaseCount.map(_ => {
          scala.io.StdIn.readLine().split(" ") match {
            case Array(funct, value) => (funct.toInt, value.toInt)
          }
        })

        if (testCases.toMap.size == testCases.size) println("YES")
        else println("NO")
      }
    )
  }
}