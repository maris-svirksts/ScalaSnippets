package hackerrank

object PrintInReverse {

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

  def printSinglyLinkedList(head: SinglyLinkedListNode, sep: String): Unit = {
    var node = head

    while (node != null) {
      print(node.data)

      node = node.next

      if (node != null) {
        print(sep)
      }
    }
  }

  // Complete the reversePrint function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     data: Int
   *     next: SinglyLinkedListNode
   * }
   *
   */
  def reversePrint(llist: SinglyLinkedListNode) {
    if(llist == null) print("")
    else {
      reversePrint(llist.next)
      println(llist.data)
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val tests = stdin.readLine.trim.toInt

    for (testsItr <- 1 to tests) {
      val llist = new SinglyLinkedList()

      val llistCount = stdin.readLine.trim.toInt

      for (_ <- 0 until llistCount) {
        val llistItem = stdin.readLine.trim.toInt
        llist.insertNode(llistItem)
      }

      reversePrint(llist.head)
    }
  }
}

