package hackerrank

import scala.io.StdIn

// https://en.wikipedia.org/wiki/Digital_root
// super_digit(n,k) = 1 + (n*k - 1) % 9
object SuperDigit {

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val data: Array[String] = StdIn.readLine().trim.split(" ")

    val result = 1 + (BigInt(data(0)) * BigInt(data(1)) - 1) % 9

    println(result)
  }
}
