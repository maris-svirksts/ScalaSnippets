package hackerrank

object ComputeThePerimeterOfAPolygon {
  def main(args: Array[String]): Unit = {
    val read = scala.io.StdIn
    val pointCount = read.readLine().toIntOption.getOrElse(0)

    val polygon: Seq[Point] = for {
      _ <- 0 until pointCount
      pointElements = read.readLine().split(" ").map(_.toInt)
    } yield Point(pointElements(0), pointElements(1))

    println(computePerimeter(polygon))
  }

  def computePerimeter(polygon: Seq[Point]): Double = {
    polygon.indices.map(indice => {
      val next = if (indice == polygon.length - 1) 0 else indice + 1

      val xCalc = (polygon(indice).x - polygon(next).x).toDouble
      val yCalc = (polygon(indice).y - polygon(next).y).toDouble

      math.sqrt(math.pow(xCalc, 2) + math.pow(yCalc, 2))
    }).sum
  }

  final case class Point(x: Int, y: Int)

}
