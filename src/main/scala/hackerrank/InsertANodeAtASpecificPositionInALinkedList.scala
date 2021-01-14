package hackerrank

import java.io._
import scala.annotation.tailrec

object InsertANodeAtASpecificPositionInALinkedList {

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

  // Complete the insertNodeAtPosition function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     data: Int
   *     next: SinglyLinkedListNode
   * }
   *
   */
  def insertNodeAtPosition(llist: SinglyLinkedListNode, data: Int, position: Int): SinglyLinkedListNode = {
    val newLinkedList = new SinglyLinkedList()
    @tailrec
    def gatherData(currentLList: SinglyLinkedListNode, add: Int): SinglyLinkedListNode = {
      if(currentLList == null) newLinkedList.head
      else {
        if(add == 0) newLinkedList.insertNode(data)
        newLinkedList.insertNode(currentLList.data)
        gatherData(currentLList.next, add - 1)
      }
    }

    gatherData(llist, position)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val llist = new SinglyLinkedList()

    val llistCount = stdin.readLine.trim.toInt

    for (_ <- 0 until llistCount) {
      val llistItem = stdin.readLine.trim.toInt
      llist.insertNode(llistItem)
    }

    val data = stdin.readLine.trim.toInt

    val position = stdin.readLine.trim.toInt

    val llist_head = insertNodeAtPosition(llist.head, data, position)

    printSinglyLinkedList(llist_head, " ", printWriter)
    printWriter.println()

    printWriter.close()
  }
}

