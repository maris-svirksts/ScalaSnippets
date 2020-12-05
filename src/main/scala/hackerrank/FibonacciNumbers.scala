package hackerrank

import scala.annotation.tailrec
import scala.io.StdIn

object FibonacciNumbers {

  def fibonacci(x: Int): Int = {
    @tailrec
    def loop(numbers: List[Int], counter: Int): Int = {
      if(numbers.size == counter - 1) numbers.head + numbers.tail.head
      else loop((numbers.head + numbers.tail.head) :: numbers, counter)
    }

    if(x < 3) x - 1
    else loop(List(1, 0), x)
  }

  def main(args: Array[String]) {
    /** This will handle the input and output**/
    println(fibonacci(StdIn.readInt()))
  }
}
