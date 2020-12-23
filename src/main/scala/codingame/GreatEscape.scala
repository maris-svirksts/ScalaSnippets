package codingame

import scala.io.StdIn._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
 **/
object Player1 extends App {
  // w: width of the board
  // h: height of the board
  // playerCount: number of players (2 or 3)
  // myId: id of my player (0 = 1st player, 1 = 2nd player, ...)
  val Array(w, h, playerCount, myId) = (readLine split " ").map(_.toInt)

  val playerOne = Array.ofDim[Int](w, 3)
  val playerTwo = Array.ofDim[Int](w, 3)
  val playerThree = Array.ofDim[Int](w, 3)
  val wallList = Array.ofDim[String](w * 2, 3)
  var counter: Int = 0

  def placeWall(playerId: Int, location: Int, secondaryPlayerId: Int): Unit = {
    playerId match {
      case 0 => {
        val x: Int =
          if (playerOne(location)(0) < 7) playerOne(location)(0) + 1
          else playerOne(location)(0)
        val y: Int = playerOne(location)(1)

        if (!wallList.contains(Array(x.toString, y.toString, "V")))
          println(s"$x $y V")
        else placeWall(secondaryPlayerId, location, -1)
      }
      case 1 => {
        val x: Int = playerTwo(location)(0)
        val y: Int =
          if (playerTwo(location)(1) <= 7) playerTwo(location)(1)
          else playerTwo(location)(1) - 1

        if (!wallList.contains(Array(x.toString, y.toString, "V")))
          println(s"$x $y V")
        else placeWall(secondaryPlayerId, location, -1)
      }
      case 2 => {
        val x: Int = playerThree(location)(0)
        val y: Int = {
          if (playerThree(location)(1) < 7) playerThree(location)(1) + 1
          else if (playerThree(location)(1) == 7) playerThree(location)(1)
          else playerThree(location)(1) - 1
        }

        if (!wallList.contains(Array(x.toString, y.toString, "H")))
          println(s"$x $y H")
        else placeWall(secondaryPlayerId, location, -1)
      }
    }
  }

  // game loop
  while (true) {
    for (i <- 0 until playerCount) {
      // x: x-coordinate of the player
      // y: y-coordinate of the player
      // wallsLeft: number of walls available for the player
      val Array(x, y, wallsLeft) = (readLine split " ").map(_.toInt)
      Console.err.print(i + ": x: " + x)
      Console.err.println(", y: " + y)

      if (i == 0) playerOne(counter) = Array(x, y, wallsLeft)
      else if (i == 1) playerTwo(counter) = Array(x, y, wallsLeft)
      else if (i == 2) playerThree(counter) = Array(x, y, wallsLeft)
    }
    val wallCount = readLine().toInt // number of walls on the board
    for (i <- 0 until wallCount) {
      // wallX: x-coordinate of the wall
      // wallY: y-coordinate of the wall
      // wallOrientation: wall orientation ('H' or 'V')
      val Array(wallX, wallY, wallOrientation) = readLine split " "

      wallList(counter) = Array(wallX, wallY, wallOrientation)
    }

    counter = counter + 1

    Console.err.print("playerOne: ")
    Console.err.println(playerOne.toList.map(x => x.toList))

    Console.err.print("playerTwo: ")
    Console.err.println(playerTwo.toList.map(x => x.toList))

    Console.err.print("playerThree: ")
    Console.err.println(playerThree.toList.map(x => x.toList))

    // Write an action using println
    // To debug: Console.err.println("Debug messages...")

    // action: LEFT, RIGHT, UP, DOWN or "putX putY putOrientation" to place a wall
    if (myId == 0) {
      if (counter == 1) placeWall(1, counter - 1, 2)
      else if (counter == 2 && playerCount > 2)
        placeWall(2, counter - 1, 1)
      else if (
        wallList.contains(
          Array(
            { playerOne(counter - 1)(0) + 1 }.toString,
            playerOne(counter - 1)(1).toString,
            "V"
          )
        )
      ) println("UP")
      else println("RIGHT")
    } else if (myId == 1) {
      if (counter == 1) placeWall(0, counter - 1, 2)
      else if (counter == 2 && playerCount > 2)
        placeWall(2, counter - 1, 0)
      else if (counter == 2) println("UP")
      else if (counter == 3) println("UP")
      else println("LEFT")
    } else if (myId == 2) {
      if (counter == 1) placeWall(0, counter - 1, 0)
      else if (counter == 2 && playerCount > 2)
        placeWall(1, counter - 1, 0)
      else if (counter == 2) println("LEFT")
      else if (counter == 3) println("LEFT")
      else println("DOWN")
    }
  }
}
