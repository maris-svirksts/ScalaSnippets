package hackerrank.DaysOfCode

//Write your code here
class Calculator() {
  def power(n: Int, p: Int): Any = {
    if(n < 0 || p < 0) "n and p should be non-negative"
    else math.pow(n, p).toInt
  }
}

object Day17MoreExceptions {
  def main(args: Array[String]) {
    val myCalculator = new Calculator()
    var T = scala.io.StdIn.readLine().toInt

    while(T > 0){
      val Array(n,p) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      try{
        val ans = myCalculator.power(n, p)
        println(ans)
      }
      catch{
        case e: Exception =>
          println(e.getMessage)
      }
      T-=1
    }
  }
}
