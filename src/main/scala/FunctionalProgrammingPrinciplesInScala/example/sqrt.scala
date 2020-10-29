package example

import scala.annotation.tailrec

object sqrt {
  def sqrt(x: Double): Double = {
    def isGoodEnough(guess: Double, x: Double): Boolean = {
      math.abs(guess * guess - x) / x < 0.001
    }

    def improve(guess: Double, x: Double): Double = {
      (guess + x / guess) / 2
    }

    @tailrec
    def sqrtIterate(guess: Double, x: Double): Double = {
      if (isGoodEnough(guess, x)) guess
      else sqrtIterate(improve(guess, x), x)
    }

    sqrtIterate(1.0, x)
  }
}