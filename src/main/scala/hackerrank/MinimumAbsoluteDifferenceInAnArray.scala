package hackerrank

// https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms

object MinimumAbsoluteDifferenceInAnArray {

  // Complete the minimumAbsoluteDifference function below.
  def minimumAbsoluteDifference(arr: Array[Int]): Int = {
    arr.sliding(2).map(x => math.abs(x(0) - x(1))).min
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val _     = stdin.readLine.trim.toInt
    val arr   = stdin.readLine.split(" ").map(_.trim.toInt).sorted

    val result = minimumAbsoluteDifference(arr)

    println(result)
  }
}

