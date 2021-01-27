package hackerrank

import scala.annotation.tailrec

object JumpingOnTheClouds {

  // Complete the jumpingOnClouds function below.
  def jumpingOnClouds(c: Array[Int]): Int = {
    @tailrec
    def loop(clouds: Array[Int], jumps: Int): Int = {
      if(clouds.isEmpty) jumps
      else if(clouds.length == 1) jumps + 1
      else if(clouds(1) == 1) loop(clouds.tail, jumps + 1)
      else loop(clouds.tail.tail, jumps + 1)
    }

    loop(c.tail, 0)
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val _      = stdin.readLine.trim.toInt
    val c      = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = jumpingOnClouds(c)

    println(result)
  }
}
