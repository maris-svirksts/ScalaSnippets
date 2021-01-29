package hackerrank

// https://www.hackerrank.com/challenges/new-year-chaos/problem

object NewYearChaos {

  // Complete the minimumBribes function below.
  def minimumBribes(q: Array[Int]): Int = {
    if(q.indices.forall(i => q(i) - i - 1 <= 2)) {
      q.indices.map(x => q.slice((q(x) - 2 :: 0 :: Nil).max, x + 1).count(y => y > q(x))).sum
    }
    else -1
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val t     = stdin.readLine.trim.toInt

    for {
      _ <- 1 to t
      _ = stdin.readLine.trim.toInt
      q = stdin.readLine.split(" ").map(_.trim.toInt)
      results = minimumBribes(q)
    } yield if(results == -1) println("Too chaotic") else println(results)
  }
}

