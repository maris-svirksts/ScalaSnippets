package hackerrank.DaysOfCode

import scala.io.StdIn.readLine

object Day28RegExPatternsAndIntroToDatabases {
  def main(args: Array[String]) {
    val N = readLine.trim.toInt

    val results = for {
      i <- 1 to N
      firstNameEmailID  = readLine.split(" ")
      firstName: String = firstNameEmailID(0)
      emailID: String   = firstNameEmailID(1)

      if emailID.endsWith("@gmail.com")
    } yield firstName

    results.sorted.foreach(x => println(x))
  }
}
