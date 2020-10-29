import math._
import scala.util._
import scala.io.StdIn._

/**
  * Save humans, destroy zombies!
 **/
object Player extends App {

  def stepsToGetThereMe(x: Int, y: Int, currentHuman: Array[Int]): Int = {
    val steps = math.abs((currentHuman(1) - x + currentHuman(2) - y) / 1000)
    Console.err.println(s"Human ${currentHuman(0)}: $steps")

    steps
  }

  def stepsToGetThereZombie(x: Int, y: Int, currentHuman: Array[Int]): Int = {
    val steps = math.abs((currentHuman(1) - x + currentHuman(2) - y) / 400)
    Console.err.println(s"Zombie ${currentHuman(0)}: $steps")

    steps
  }

  def isSavable(
      currentHuman: Array[Int],
      zombieList: Array[Array[Int]],
      x: Int,
      y: Int
  ): Boolean = {
    zombieList.forall(location => {
      stepsToGetThereMe(x, y, currentHuman) < stepsToGetThereZombie(
        location(1),
        location(2),
        currentHuman
      )
    })
  }

  // game loop
  while (true) {
    val Array(x, y) = (readLine split " ").map(_.toInt)
    val humanCount = readLine.toInt
    val humanList = Array.ofDim[Int](humanCount, 3)

    for (i <- 0 until humanCount) {
      humanList(i) = (readLine split " ").map(_.toInt)
      Console.err.println(s"${humanList(i)(1)} ${humanList(i)(2)}")
    }

    val zombieCount = readLine.toInt
    val zombieList = Array.ofDim[Int](zombieCount, 5)
    for (i <- 0 until zombieCount) {
      zombieList(i) = (readLine split " ").map(_.toInt)
    }

    // Write an action using println
    // To debug: Console.err.println("Debug messages...")

    val savableHumans = for {
      currentHuman <- humanList
      if isSavable(currentHuman, zombieList, x, y)
    } yield currentHuman

    if (1 == zombieCount) println(s"${zombieList(0)(1)} ${zombieList(0)(2)}")
    else if (savableHumans.isEmpty)
      println(
        s"${humanList(0)(1)} ${humanList(0)(2)}"
      )
    else
      println(
        s"${savableHumans(0)(1)} ${savableHumans(0)(2)}"
      ) // Your destination coordinates
  }
}
