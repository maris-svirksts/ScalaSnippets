package hackerrank

import java.io._
import scala.annotation.tailrec

object GetNodeValue {

  class SinglyLinkedListNode(var data: Int, var next: SinglyLinkedListNode = null) {
  }

  class SinglyLinkedList(var head: SinglyLinkedListNode = null, var tail: SinglyLinkedListNode = null) {
    def insertNode(nodeData: Int): Unit = {
      val node = new SinglyLinkedListNode(nodeData)

      if (this.head == null) {
        this.head = node
      } else {
        this.tail.next = node
      }

      this.tail = node
    }
  }

  def printSinglyLinkedList(head: SinglyLinkedListNode, sep: String, printWriter: PrintWriter): Unit = {
    var node = head

    while (node != null) {
      printWriter.print(node.data)

      node = node.next

      if (node != null) {
        printWriter.print(sep)
      }
    }
  }

  // Complete the getNode function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     data: Int
   *     next: SinglyLinkedListNode
   * }
   *
   */
  def getNode(llist: SinglyLinkedListNode, positionFromTail: Int): Int = {
    @tailrec
    def getData(currentLList: SinglyLinkedListNode, newArray: Array[Int]): Int = {
      if(currentLList == null) newArray(positionFromTail)
      else getData(currentLList.next, currentLList.data +: newArray)
    }

    getData(llist, Array())
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val tests = stdin.readLine.trim.toInt

    for (testsItr <- 1 to tests) {
      val llist = new SinglyLinkedList()

      val llistCount = stdin.readLine.trim.toInt

      for (_ <- 0 until llistCount) {
        val llistItem = stdin.readLine.trim.toInt
        llist.insertNode(llistItem)
      }

      val position = stdin.readLine.trim.toInt

      val result = getNode(llist.head, position)

      printWriter.println(result)
    }

    printWriter.close()
  }
}

