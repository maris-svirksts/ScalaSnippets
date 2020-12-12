package AdventOfCode

import scala.annotation.tailrec
import scala.io.{BufferedSource, Source}

object BinaryBoarding extends App {
  val readFile: BufferedSource = Source.fromFile("src/main/scala/AdventOfCode/BinaryBoarding.txt")
  val list: List[String]       = readFile.getLines().toList
  readFile.close()

  def calcID(row: Int, col: Int): Int = {
    row * 8 + col
  }

  @tailrec
  def loop(range: List[Int], boardingPass: String): Int = {
    if(boardingPass.isEmpty) range.headOption.getOrElse(-1)
    else {
      val _@(upper, lower)       = range.splitAt(range.length/2)
      val updatedList: List[Int] = if (List('F', 'L').contains(boardingPass.headOption.getOrElse(Nil))) upper else lower

      loop(updatedList, boardingPass.tail)
    }
  }

  val passes = for{
    boardingPass <- list
    _@(rowData, columnData) = boardingPass.splitAt(7)

    row  = loop(List.range(0, 128), rowData)
    col  = loop(List.range(0, 8), columnData)
    calc = calcID(row, col)
  } yield (row, col, calc)

  val _@(emptyRow, emptyTemp) = passes.groupBy(x => x._1).filter(x => x._2.length != 8).toList.sortBy(x => x._1).tail.headOption.get
  val emptyCol: List[Int]     = List.range(0,8).filter(x => emptyTemp.forall(y => y._2 != x))

  println("All: " + passes)
  println("Max: " + passes.sortBy( x => x._3).reverse.headOption.getOrElse(-1))
  println("Your Id: " + calcID(emptyRow, emptyCol.headOption.getOrElse(0)))
}
