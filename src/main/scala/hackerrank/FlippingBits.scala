package hackerrank

// https://www.hackerrank.com/challenges/flipping-bits/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous
// this number is (2**32)-1
// unsigned integers given which is 32
// 2**32 = 4294967296
// to flip is to just minus 1

object FlippingBits {

  // Complete the flippingBits function below.
  def flippingBits(n: Long): Long = {
    n ^ 4294967295L
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val q = stdin.readLine.trim.toInt

    for{
      _ <- 1 to q
      result = flippingBits(stdin.readLine.trim.toLong)
    } yield println(result)
  }
}
