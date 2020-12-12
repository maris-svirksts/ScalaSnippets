package AdventOfCode

import scala.io.Source

object CustomCustoms extends App {
  val readFile: String     = Source.fromFile("src/main/scala/AdventOfCode/CustomCustoms.txt").mkString
  val common: List[String] = readFile.split("\n\n").toList

  val uniqueElements_p1 = common.map(x => x.replaceAll("[^a-z]", "").toSeq.distinct.length)
  println("First Task: " + uniqueElements_p1.sum)

  val uniqueElements_p2 = common.map(x => x.split("\n").toList)
  val results_p2 = for {
    i <- uniqueElements_p2
    subListLength: Int = i.size
    mergedList: Int    = i.flatten.groupBy(x => x).map(x => x._2.length).filter(x => x == subListLength).toList.length
  } yield mergedList

  println("Second Task: " + results_p2.sum)
}

