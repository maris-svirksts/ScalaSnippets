package AdventOfCode

import scala.io.{BufferedSource, Source}
import scala.util.matching.Regex

object PasswordPhilosophy extends App {
  val keyValPattern: Regex = "(\\d+)-(\\d+) (\\w): (\\w+)".r

  val readFile: BufferedSource = Source.fromFile("src/main/scala/AdventOfCode/passwordPhilosophy.txt")
  val list: List[String] = readFile.getLines().toList
  readFile.close()

  val result_p1 = for{
    i <- list
    keyValPattern(from, to, letter, element) = i
    letterCount = element.count(_.toString == letter)
    if letterCount >= from.toInt
    if letterCount <= to.toInt
  } yield List(from, to, letter, element)

  println("result_p1 size: " + result_p1.size)

  val result_p2 = for{
    i <- list
    keyValPattern(from, to, letter, element) = i
    if (element(from.toInt - 1).toString == letter) ^ (element(to.toInt - 1).toString == letter)
  } yield List(from, to, letter, element)

  println("result_p2 size: " + result_p2.size)
}


