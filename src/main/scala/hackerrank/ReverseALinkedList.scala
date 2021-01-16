package hackerrank

import java.io._
import scala.annotation.tailrec

object ReverseALinkedList {

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

  // Complete the reverse function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     data: Int
   *     next: SinglyLinkedListNode
   * }
   *
   */
  def reverse(llist: SinglyLinkedListNode): SinglyLinkedListNode = {
    @tailrec
    def fillList(data: SinglyLinkedListNode, elements: scala.List[Int]): scala.List[Int] = {
      if(data == null) elements
      else fillList(data.next, data.data :: elements)
    }

    val data = fillList(llist, scala.List())
    val results = new SinglyLinkedList()


    for{
      i <- data
    } yield results.insertNode(i)

    results.head
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val tests = stdin.readLine().trim.toInt

    for (testsItr <- 1 to tests) {
      val llist = new SinglyLinkedList()

      val llistCount = stdin.readLine().trim.toInt

      for (_ <- 0 until llistCount) {
        val llistItem = stdin.readLine().trim.toInt
        llist.insertNode(llistItem)
      }

      val llist1 = reverse(llist.head)

      printSinglyLinkedList(llist1, " ", printWriter)
      printWriter.println()
    }

    printWriter.close()
  }
}

