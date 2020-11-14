package hackerrank

import java.io._
import scala.io._

object ResultGradingStudents {

  /*
   * Complete the 'gradingStudents' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY grades as parameter.
   */

  def gradingStudents(grades: Array[Int]): Array[Int] = {
    // Write your code here
    grades.map {
      case x if x < 38 => x
      case x if x % 5 > 2 => x + (5 - (x % 5))
      case x@default => x
    }
  }

}

object GradingStudents {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val gradesCount = StdIn.readLine().trim.toInt

    val grades = Array.ofDim[Int](gradesCount)

    for (i <- 0 until gradesCount) {
      val gradesItem = StdIn.readLine().trim.toInt
      grades(i) = gradesItem
    }

    val result = ResultGradingStudents.gradingStudents(grades)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
