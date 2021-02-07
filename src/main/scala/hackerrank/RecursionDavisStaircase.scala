package hackerrank

// https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking

object RecursionDavisStaircase {

  // Complete the stepPerms function below.
  def stepPerms(n: Int): Int = {
    if(n == 1) 1
    else if(n == 2) 2
    else if(n == 3) 4
    else stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3)
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn
    val s     = stdin.readLine.trim.toInt

    val elements = for {
      _ <- 1 to s
    } yield stdin.readLine.trim.toInt

    val results: Map[Int, Int] = elements.distinct.map(x => (x, stepPerms(x))).toMap

    elements.foreach(x => println(results(x)))
  }
}
