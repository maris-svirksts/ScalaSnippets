package hackerrank

// https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

import scala.annotation.tailrec

object MinimumSwaps2 {

  // Complete the minimumSwaps function below.
  def minimumSwaps(arr: Array[Int]): Int = {
    val length = arr.length - 1

    @tailrec
    def loop(counter: Int, location: Int): Int = {
      if(length == location) counter
      else if(arr(location) < arr(location + 1)) loop(counter, location + 1)
      else {
        val temp = arr(arr(location) - 1)
        arr.update(arr(location) - 1, arr(location))
        arr.update(location, temp)
        loop(counter + 1, (location - 1 :: 0 :: Nil).max)
      }
    }

    loop(0, 0)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val _     = stdin.readLine.trim.toInt
    val arr   = stdin.readLine.split(" ").map(_.trim.toInt)

    val res = minimumSwaps(arr)
    println(res)
  }
}