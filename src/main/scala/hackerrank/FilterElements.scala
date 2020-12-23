package hackerrank

object FilterElements {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val numberOfTestCases = stdin.readLine().trim.toInt
    val result = for {
      i <- 0 until numberOfTestCases
      helperData = stdin.readLine().split(" ")
      usefulHelper = helperData(1).trim.toInt
      elementList = stdin.readLine().split(" ").map(x => x.trim.toInt)
      groupedElements = elementList.groupBy(x => x)
      diffElements = elementList.distinct.filter(x => groupedElements(x).length >= usefulHelper)
    } yield if (diffElements.isEmpty) List(-1) else diffElements.toList

    result.foreach(x => println(x.mkString(" ")))
  }
}
