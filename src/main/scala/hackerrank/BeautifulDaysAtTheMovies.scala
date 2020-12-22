package hackerrank

import java.io._

object BeautifulDaysAtTheMovies {

  // Complete the beautifulDays function below.
  def beautifulDays(i: Int, j: Int, k: Int): Int = {
    val listOfDays = i to j
    listOfDays.map(x => {
      val reversed: Int = x.toString.reverse.toInt
      math.abs(x - reversed) % k
    }).count(_ == 0)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val ijk = stdin.readLine.split(" ")

    val i = ijk(0).trim.toInt

    val j = ijk(1).trim.toInt

    val k = ijk(2).trim.toInt

    val result = beautifulDays(i, j, k)

    printWriter.println(result)

    printWriter.close()
  }
}

