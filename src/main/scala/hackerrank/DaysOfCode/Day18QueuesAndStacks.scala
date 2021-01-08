package hackerrank.DaysOfCode

import scala.collection.mutable
import scala.util.control._

class Solution {
  var stackData = new mutable.Stack[Char]()
  var queueData = new mutable.Queue[Char]()
  def pushCharacter(i: Char): mutable.Stack[Char] = {
    stackData.push(i)
  }

  def popCharacter(): Char = {
    stackData.pop()
  }

  def enqueueCharacter(i: Char): mutable.Queue[Char] = {
    queueData.enqueue(i)
  }

  def dequeueCharacter(): Char = {
    queueData.dequeue()
  }
}

object Day18QueuesAndStacks {
  def main(args: Array[String]) {
    // read the string s
    var s=scala.io.StdIn.readLine()
    // create the Solution class object p
    var obj=new Solution()
    var i=0
    var len=s.length()
    //push/enqueue all the characters of string s to stack
    for(i<- 0 until len){
      obj.pushCharacter(s.charAt(i))
      obj.enqueueCharacter(s.charAt(i))
    }

    var isPalindrome=true
    /*pop the top character from stack
      dequeue the first character from queue
      compare both the characters*/

    val loop = new Breaks
    loop.breakable {
      for(i<- 0 to len/2){
        if(obj.popCharacter()!=obj.dequeueCharacter()){
          isPalindrome=false
          loop.break
        }
      }
    }

    //finally print whether string s is palindrome or not
    if(isPalindrome){
      println("The word, "+s+", is a palindrome." )
    }
    else{
      println("The word, "+s+", is not a palindrome." )
    }
  }
}
