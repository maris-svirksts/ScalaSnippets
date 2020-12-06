package hackerrank

import scala.annotation.tailrec
import scala.io.StdIn

object Solution {
  @tailrec
  def loop(str: String, charToCheck: Char, counter: Int, resultList: List[String]): List[String] = {
    if(str.isEmpty) {
      if(counter > 1) s"$charToCheck$counter" :: resultList
      else charToCheck.toString :: resultList
    }
    else if(charToCheck == str.head) loop(str.tail, charToCheck, counter + 1, resultList)
    else if(counter > 1) loop(str.tail, str.head, 1, s"$charToCheck$counter" :: resultList)
    else loop(str.tail, str.head, 1, charToCheck.toString :: resultList)
  }

  def main(args: Array[String]) {
    val stringToTransform: String  = StdIn.readLine().trim

    if(stringToTransform.isEmpty) ""
    else println(loop(stringToTransform.tail, stringToTransform.head, 1, List()).reverse.mkString(""))
  }
}
