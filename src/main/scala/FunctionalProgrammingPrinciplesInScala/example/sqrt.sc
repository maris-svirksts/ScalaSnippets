import scala.annotation.tailrec

object sqrt {
  def sqrt(x: Double): Double = {
    def isGoodEnough(guess: Double): Boolean = {
      math.abs(guess * guess - x) / x < 0.001
    }

    def improve(guess: Double): Double = {
      (guess + x / guess) / 2
    }

    @tailrec
    def sqrtIterate(guess: Double): Double = {
      if (isGoodEnough(guess)) guess
      else sqrtIterate(improve(guess))
    }

    sqrtIterate(1.0)
  }

  def factorial(x: Int): Int = {
    @tailrec
    def loop(acc: Int, x: Int): Int = {
      if(x == 0) acc
      else loop(acc*x, x-1)
    }
    loop(1, x)
  }
}