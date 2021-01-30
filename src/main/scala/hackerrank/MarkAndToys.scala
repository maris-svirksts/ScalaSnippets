package hackerrank

// https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting

import scala.annotation.tailrec

object MarkAndToys {

  // Complete the maximumToys function below.
  def maximumToys(prices: Array[Int], k: Int): Int = {

    @tailrec
    def loop(toys: Array[Int], sum: Int, counter: Int): Int = {
      if(toys.isEmpty || sum + toys.head > k) counter
      else loop(toys.tail, sum + toys.head, counter + 1)
    }

    loop(prices.sorted, 0, 0)
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn
    val nk    = stdin.readLine.split(" ")
    val _     = nk(0).trim.toInt
    val k     = nk(1).trim.toInt

    val prices = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = maximumToys(prices, k)

    println(result)
  }
}

