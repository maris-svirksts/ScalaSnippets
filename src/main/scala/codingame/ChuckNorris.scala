package codingame

import scala.annotation.tailrec
import scala.io.StdIn._

object ChuckNorris extends App {
  val initialMessage = readLine
  val message: String = initialMessage.map(x => {
    val element = x.toByte.toBinaryString
    if(element.length >= 7) element else {
      val missing = 7 - element.length
      (for(_ <- 0 until missing) yield 0).mkString("") + element
    }
  }).mkString("")

  println(translate(message, "").trim)

  @tailrec
  def translate(oldMessage: String, newMessage: String): String = {
    if(oldMessage.isEmpty) newMessage
    else {
      val currentElement       = oldMessage.takeWhile(_ == oldMessage.head)
      val currentElementLength = currentElement.length
      val newElementBase       = currentElement.map(_ => 0).mkString("")
      val newElement           = if (oldMessage.head == '1') s"0 $newElementBase " else if(oldMessage.head == '0') s"00 $newElementBase " else s"${oldMessage.head}"

      translate(oldMessage.substring(currentElementLength), newMessage + newElement)
    }
  }
}
