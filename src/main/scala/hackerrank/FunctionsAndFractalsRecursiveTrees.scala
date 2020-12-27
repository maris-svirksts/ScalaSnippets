package hackerrank

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object Solution {
  @tailrec
  def init(counter: Int, branchHeight: Int, totalHeight: Int, startingPoint: List[Int], elements: Int, results: List[List[Char]]): List[List[Char]] = {
    @tailrec
    def loop(currentBranchHeight: Int, list: List[Char], result: List[List[Char]]): List[List[Char]] = {
      if(currentBranchHeight == 0) result
      else loop(
        currentBranchHeight - 1,
        list,
        list.indices.map(x => {
          if(startingPoint.contains(x) && (branchHeight < currentBranchHeight * 2) ) '1'
          else if(
            (
              startingPoint.contains(x - (currentBranchHeight - 1 - branchHeight / 2)) ||
              startingPoint.contains(x + (currentBranchHeight - 1 - branchHeight / 2 ))
            ) &&
              (branchHeight >= currentBranchHeight * 2)
          ) '1'
          else '_'
        }).toList :: result)
    }

    if(counter > elements) {
      List.fill(totalHeight)(List.fill(100)('_')) ++ results
    }
    else init(
      counter + 1,
      branchHeight / 2,
      totalHeight - branchHeight,
      startingPoint.flatMap(x => List(x - (branchHeight / 2), x + (branchHeight / 2))),
      elements,
      loop(
        branchHeight,
        List.fill(100)('_'),
        List()) ++ results
    )
  }

  def main(args: Array[String]): Unit = {
    init(1, 32, 63, List(49), readLine().toInt, List()).foreach(x => println(x.mkString))
  }
}
