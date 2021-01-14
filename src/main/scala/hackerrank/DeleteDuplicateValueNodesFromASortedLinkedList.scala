package hackerrank

import java.io._
import scala.annotation.tailrec

object DeleteDuplicateValueNodesFromASortedLinkedList {

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

  // Complete the removeDuplicates function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     data: Int
   *     next: SinglyLinkedListNode
   * }
   *
   */
  def removeDuplicates(head: SinglyLinkedListNode): SinglyLinkedListNode = {
    val newLinkedList = new SinglyLinkedList()

    @tailrec
    def getData(currentLList: SinglyLinkedListNode, newList: scala.List[Int]): scala.List[Int] = {
      if(currentLList == null) newList.distinct.reverse
      else getData(currentLList.next, currentLList.data :: newList)
    }

    getData(head, scala.List()).foreach(x => newLinkedList.insertNode(x))

    newLinkedList.head
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val llist = new SinglyLinkedList()

      val llistCount = stdin.readLine.trim.toInt

      for (_ <- 0 until llistCount) {
        val llistItem = stdin.readLine.trim.toInt
        llist.insertNode(llistItem)
      }

      val llist1 = removeDuplicates(llist.head)

      printSinglyLinkedList(llist1, " ", printWriter)
      printWriter.println()
    }

    printWriter.close()
  }
}

