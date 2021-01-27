package hackerrank.Nutanix

import scala.math.Numeric.BigIntIsIntegral.abs

object MakingCandies {
  // Complete the minimumPasses function below.
  def minimumPasses(m: BigInt, w: BigInt, p: BigInt, n: BigInt): BigInt = {
    var days    = BigInt(0)
    var candies = BigInt(0)

    var machines = m
    var workers  = w
    val machinesTimesWorkers = machines * workers

    var answer = if(n % machinesTimesWorkers != BigInt(0)) n / machinesTimesWorkers + BigInt(1) else n / machinesTimesWorkers

    while(days < answer) {
      if(p > candies) {
        val machinesTimesWorkers = machines * workers
        val daysNeeded = if((p - candies) % machinesTimesWorkers != BigInt(0)) (p - candies) / machinesTimesWorkers + BigInt(1) else (p - candies) / machinesTimesWorkers
        candies        = candies + daysNeeded * machinesTimesWorkers
        days           = days + daysNeeded
      }

      val diff      = abs(machines - workers)
      val available = candies / p
      val purchased = (diff :: available :: Nil).min

      if(machines < workers) machines = machines + purchased
      else workers = workers + purchased

      val rest = available - purchased
      machines = machines + rest / 2
      workers  = workers +  rest - rest / 2
      candies  = candies - available * p

      candies = candies + machines * workers
      days    = days + 1

      val remainingCandies = (n - candies :: BigInt(0) :: Nil).max

      val machinesTimesWorkers = machines * workers
      val additionalDays = if(remainingCandies % machinesTimesWorkers != BigInt(0)) remainingCandies / machinesTimesWorkers + BigInt(1) else remainingCandies / machinesTimesWorkers

      answer = (answer :: days + additionalDays :: Nil).min
    }

    answer
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val mwpn = stdin.readLine.split(" ")
    val m    = BigInt(mwpn(0).trim)
    val w    = BigInt(mwpn(1).trim)
    val p    = BigInt(mwpn(2).trim)
    val n    = BigInt(mwpn(3).trim)

    val result = minimumPasses(m, w, p, n)

    println(result)
  }
}
