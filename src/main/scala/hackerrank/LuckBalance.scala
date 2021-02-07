package hackerrank

object LuckBalance {

  // Complete the luckBalance function below.
  def luckBalance(k: Int, contests: IndexedSeq[List[Int]]): Int = {
    val unimportantContests = contests.filter(x => x(1) == 0).foldLeft(0)((sum, element) => sum + element.head)
    val importantContests   = contests.filter(x => x(1) != 0).sortBy(y => y.head).reverse.splitAt(k)

    val plus  = importantContests._1.foldLeft(0)((sum, element) => sum + element.head)
    val minus = importantContests._2.foldLeft(0)((sum, element) => sum + element.head)

    unimportantContests + plus - minus
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val nk = stdin.readLine.split(" ")
    val n  = nk(0).trim.toInt
    val k  = nk(1).trim.toInt

    val contests = for {
      _ <- 0 until n
    } yield stdin.readLine.split(" ").map(_.trim.toInt).toList

    val result = luckBalance(k, contests)

    println(result)
  }
}

