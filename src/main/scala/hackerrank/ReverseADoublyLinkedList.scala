package hackerrank

import java.io._
import scala.annotation.tailrec

object ReverseADoublyLinkedList {

  class DoublyLinkedListNode(var data: Int, var next: DoublyLinkedListNode = null, var prev: DoublyLinkedListNode = null) {
  }

  class DoublyLinkedList(var head: DoublyLinkedListNode = null, var tail: DoublyLinkedListNode = null) {
    def insertNode(nodeData: Int): Unit = {
      val node = new DoublyLinkedListNode(nodeData)

      if (this.head == null) {
        this.head = node
      } else {
        this.tail.next = node
        node.prev = this.tail
      }

      this.tail = node
    }
  }

  def printDoublyLinkedList(head: DoublyLinkedListNode, sep: String, printWriter: PrintWriter): Unit = {
    var node = head

    while (node != null) {
      printWriter.print(node.data)

      node = node.next

      if (node != null) {
        printWriter.print(sep)
      }
    }
  }

  // Complete the reverse function below.

  /*
   * For your reference:
   *
   * DoublyLinkedListNode {
   *     data: Int
   *     next: DoublyLinkedListNode
   *     prev: DoublyLinkedListNode
   * }
   *
   */
  def reverse(llist: DoublyLinkedListNode): DoublyLinkedListNode = {

    @tailrec
    def reverseToEnd(llist: DoublyLinkedListNode): DoublyLinkedListNode = {
      if(llist.next == null) llist
      else reverseToEnd(llist.next)
    }

    @tailrec
    def fillLlist(node: DoublyLinkedListNode, list: DoublyLinkedList): DoublyLinkedListNode = {
      if(node == null) list.head
      else {
        list.insertNode(node.data)
        fillLlist(node.prev, list)
      }
    }

    val node     = reverseToEnd(llist)
    val newLlist = new DoublyLinkedList()
    fillLlist(node, newLlist)
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val llist = new DoublyLinkedList()

      val llistCount = stdin.readLine.trim.toInt

      for (_ <- 0 until llistCount) {
        val llistItem = stdin.readLine.trim.toInt
        llist.insertNode(llistItem)
      }

      val llist1 = reverse(llist.head)

      printDoublyLinkedList(llist1, " ", printWriter)
      printWriter.println()
    }

    printWriter.close()
  }
}

