package hackerrank.DaysOfCode

object Day10BinaryNumbers {
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    println(stdin.readLine.trim.toInt.toBinaryString.split("0").map(_.length).max)
  }
}
