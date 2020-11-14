package hackerrank

object AppleAndOrange {

  // Complete the countApplesAndOranges function below.
  def countApplesAndOranges(houseStart: Int, houseEnd: Int, appleTree: Int, orangeTree: Int, apples: Array[Int], oranges: Array[Int]) {
    val appleCount = apples.filter(x => {x >= 0 && x >= (houseStart - appleTree) && x <= (houseEnd - appleTree)})
    val orangeCount = oranges.filter(x => {x <= 0 && x <= houseEnd - orangeTree && x >= (houseStart - orangeTree)})

    println(appleCount.length)
    println(orangeCount.length)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val st = stdin.readLine.split(" ")
    val s = st(0).trim.toInt
    val t = st(1).trim.toInt

    val ab = stdin.readLine.split(" ")
    val a = ab(0).trim.toInt
    val b = ab(1).trim.toInt

    val mn = stdin.readLine.split(" ")
    val m = mn(0).trim.toInt
    val n = mn(1).trim.toInt

    val apples = stdin.readLine.split(" ").map(_.trim.toInt)
    val oranges = stdin.readLine.split(" ").map(_.trim.toInt)

    countApplesAndOranges(s, t, a, b, apples, oranges)
  }
}

