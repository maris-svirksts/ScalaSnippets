package hackerrank

import scala.io.StdIn

object StringoPermute {

  def main(args: Array[String]): Unit = {
    val numberOfLines: Int  = StdIn.readLine().trim.toInt

    for{
      _ <- 0 until numberOfLines
      stringToTransform = StdIn.readLine().trim
    } yield println(stringToTransform.toSeq.sliding(2, 2).map(x => s"${x.last}${x.head}").mkString(""))
  }
}
