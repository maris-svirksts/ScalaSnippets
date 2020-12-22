package AdventOfCode

import scala.io.{BufferedSource, Source}

object HandyHaversacks extends App {
  val readFile: BufferedSource = Source.fromFile("src/main/scala/AdventOfCode/HandyHaversacks.txt")
  val list: List[String]       = readFile.getLines().toList
  readFile.close()

  val searchFor = "shiny gold bag"

  val results_p1 = list.count(x => x.matches(".+\\d\\s(shiny gold bag).*"))
  println(results_p1)
}
