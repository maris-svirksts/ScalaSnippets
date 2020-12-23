package hackerrank

import java.io._

object CatsAndAMouse {

  // Complete the catAndMouse function below.
  def catAndMouse(catA: Int, catB: Int, mouse: Int): String = {
    val catADistance = math.abs(catA - mouse)
    val catBDistance = math.abs(catB - mouse)

    if(catADistance < catBDistance) "Cat A"
    else if(catADistance > catBDistance) "Cat B"
    else "Mouse C"
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val q = stdin.readLine().trim.toInt

    for (qItr <- 1 to q) {
      val xyz = stdin.readLine().split(" ")

      val x = xyz(0).trim.toInt

      val y = xyz(1).trim.toInt

      val z = xyz(2).trim.toInt

      val result = catAndMouse(x, y, z)

      printWriter.println(result)
    }

    printWriter.close()
  }
}

