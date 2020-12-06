package hackerrank

import scala.io.StdIn

object RotateString {

  def main(args: Array[String]): Unit = {
    val numberOfLines: Int  = StdIn.readLine().trim.toInt

    val toShow = for{
      _ <- 0 until numberOfLines
      stringToTransform: String = StdIn.readLine().trim
      strLength: Int            = stringToTransform.length
      results: Seq[String]      = for{
        i <- 1 to strLength
        resultList = stringToTransform.splitAt(i)
        result = resultList._2 + resultList._1
      } yield result
    } yield results

    toShow.foreach(x => {
      println(x.mkString(" "))
    })
  }
}
