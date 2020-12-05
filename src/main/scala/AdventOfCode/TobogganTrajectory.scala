package AdventOfCode

import scala.annotation.tailrec
import scala.io.{BufferedSource, Source}

object TobogganTrajectory extends App {
  val readFile: BufferedSource = Source.fromFile("src/main/scala/AdventOfCode/tobogganTrajectory.txt")
  val list: List[String] = readFile.getLines().toList
  readFile.close()

  @tailrec
  def loop(lines: List[String], position: Int, right: Int, trees: Int ): Int = {
    if(lines.isEmpty) trees
    else if(lines.head(position) == '#') loop(lines.tail, (position + right) % lines.head.length, right, trees + 1)
    else loop(lines.tail, (position + right) % lines.head.length, right, trees)
  }

  println("Right 1, down 1: " + loop(list, 0, 1, 0))
  println("Right 3, down 1: " + loop(list, 0, 3, 0))
  println("Right 5, down 1: " + loop(list, 0, 5, 0))
  println("Right 7, down 1: " + loop(list, 0, 7, 0))

  println("Right 1, down 2: " + loop(list.indices.collect{case x if x % 2 == 0 => list(x)}.toList, 0, 1, 0))
}
