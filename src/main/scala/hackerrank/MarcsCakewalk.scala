package hackerrank

// https://www.hackerrank.com/challenges/marcs-cakewalk/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

object MarcsCakewalk {

  // Complete the marcsCakewalk function below.
  def marcsCakewalk(calorie: Array[Int]): Long = {
    calorie.sortWith(_ > _).zipWithIndex.map{case (number, index) => math.pow(2, index).toLong * number}.sum
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn
    val _     = stdin.readLine.trim.toInt

    val calorie = stdin.readLine.split(" ").map(_.trim.toInt)
    val result  = marcsCakewalk(calorie)

    println(result)
  }
}

