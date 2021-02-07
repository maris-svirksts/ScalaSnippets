package hackerrank

// https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking

import scala.io.StdIn.readInt

object RecursionFibonacciNumbers {

  def fibonacci(x:Int):Int = {
    // Write your code here. You may add a helper function as well, if necessary.
    if(x == 1) 1
    else if(x == 0) 0
    else fibonacci(x - 1) + fibonacci(x - 2)
  }

  def main(args: Array[String]): Unit = {
    /** This will handle the input and output**/
    println(fibonacci(readInt()))

  }
}
