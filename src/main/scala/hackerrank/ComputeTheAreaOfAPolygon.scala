package hackerrank

//https://www.mathopenref.com/coordpolygonarea.html

object ComputeTheAreaOfAPolygon {
  def main(args: Array[String]): Unit = {
    val read = scala.io.StdIn
    val pointCount = read.readLine().toIntOption.getOrElse(0)

    val polygon: Seq[Point] = for {
      _ <- 0 until pointCount
      pointElements = read.readLine().split(" ").map(_.toInt)
    } yield Point(pointElements(0), pointElements(1))

    println(computeArea(polygon))
  }

  def computeArea(polygon: Seq[Point]): Double = {
    val topSide: Double = polygon.indices.map(indice => {
      val next = if (indice == polygon.length - 1) 0 else indice + 1

      val xCalc = (polygon(indice).x * polygon(next).y).toDouble
      val yCalc = (polygon(indice).y * polygon(next).x).toDouble

      xCalc - yCalc
    }).sum

    math.abs(topSide / 2)
  }

  final case class Point(x: Int, y: Int)

}
