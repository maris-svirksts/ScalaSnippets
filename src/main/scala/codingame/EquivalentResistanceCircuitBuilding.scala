package codingame

import scala.annotation.tailrec
import scala.io.StdIn._

object EquivalentResistanceCircuitBuilding extends App {
  val n = readLine.toInt

  val values: Map[String, Int] = (for {
    _ <- 0 until n
    Array(name, _r) = readLine split " "
  } yield (name, _r.toInt)).toMap

  val circuit = readLine.split(" ").map(x => values.getOrElse(x, x))
  val result  = calculateResults(circuit)

  println("%1.1f".format(result))

  @tailrec
  def calculateResults(circuit: IndexedSeq[Any]): Float = {
    if(circuit.length == 1) circuit.head.toString.toFloat
    else {
      val lastParallel = circuit.lastIndexWhere(_ == "[")
      val lastSeries   = circuit.lastIndexWhere(_ == "(")

      val (currentIndex, currentType) = if(lastParallel > lastSeries) (lastParallel, "]") else (lastSeries, ")")

      val (before, next)   = circuit.splitAt(currentIndex + 1)
      val nextSeries       = next.indexWhere(_ == currentType)
      val (current, after) = next.splitAt(nextSeries)

      val sum: Float = if(currentType == ")") current.map(x => x.toString.toFloat).sum else 1 / current.map(x => 1 / x.toString.toFloat).sum

      calculateResults(before.init.appended(sum) ++ after.tail)
    }
  }
}
