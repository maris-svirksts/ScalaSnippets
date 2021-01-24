package hackerrank

object IntroToTutorialChallenges {

  // Complete the introTutorial function below.
  def introTutorial(V: Int, arr: Array[Int]): Int = {
    arr.indexOf(V)
  }

  def main(args: Array[String]): Unit = {
    val stdin  = scala.io.StdIn
    val V      = stdin.readLine.trim.toInt
    val _      = stdin.readLine.trim.toInt
    val arr    = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = introTutorial(V, arr)

    println(result)
  }
}

