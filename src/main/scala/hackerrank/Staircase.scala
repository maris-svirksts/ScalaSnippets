package hackerrank

object Staircase {

  // Complete the staircase function below.
  def staircase(n: Int) {
    for( i <- 1 to n ) {
      print(" " * {n - i} )
      println("#" * i)
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    staircase(n)
  }
}
