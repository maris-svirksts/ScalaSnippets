package hackerrank

import java.io._
import scala.annotation.tailrec

object DeleteANode {

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

  // Complete the deleteNode function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     data: Int
   *     next: SinglyLinkedListNode
   * }
   *
   */
  def deleteNode(llist: SinglyLinkedListNode, position: Int): SinglyLinkedListNode = {
    val newLinkedList = new SinglyLinkedList()
    @tailrec
    def gatherData(currentLList: SinglyLinkedListNode, remove: Int): SinglyLinkedListNode = {
      if(currentLList == null) newLinkedList.head
      else {
        if(remove != 0) newLinkedList.insertNode(currentLList.data)
        gatherData(currentLList.next, remove - 1)
      }
    }

    gatherData(llist, position)
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val llist = new SinglyLinkedList()

    val llistCount = stdin.readLine.trim.toInt

    for (_ <- 0 until llistCount) {
      val llistItem = stdin.readLine.trim.toInt
      llist.insertNode(llistItem)
    }

    val position = stdin.readLine.trim.toInt

    val llist1 = deleteNode(llist.head, position)

    printSinglyLinkedList(llist1, " ", printWriter)
    printWriter.println()

    printWriter.close()
  }
}

