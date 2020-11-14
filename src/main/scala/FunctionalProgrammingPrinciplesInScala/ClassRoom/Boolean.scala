package FunctionalProgrammingPrinciplesInScala.ClassRoom

/*abstract class Boolean {
  def ifThenElse[T](t: => T, e: => T): T
  def && (x: => Boolean): Boolean = ifThenElse(x, false)
  def || (x: => Boolean): Boolean = ifThenElse(true, x)
  def unary_! : Boolean = ifThenElse(false, true)
  def == (x: Boolean): Boolean = ifThenElse(x, x.unary_!)
  def != (x: Boolean): Boolean = ifThenElse(x.unary_!, x)
  def < (x: Boolean) = ifThenElse(false, x)
}*/

//object true extends Boolean {
//  def ifThenElse[T](t: => T, e: => T): T = t
//}

//object false extends Boolean {
//  def ifThenElse[T](t: => T, e: => T): T = e
//}

// Peano numbers
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  override def isZero: Boolean = true
  override def predecessor: Nat = throw new Error("No negative numbers.")
  override def +(that: Nat): Nat = that
  override def -(that: Nat): Nat = if(that.isZero) this else throw new Error("No negative numbers.")
}

class Succ(n: Nat) extends Nat {
  override def isZero: Boolean = false
  override def predecessor: Nat = n
  override def +(that: Nat): Nat = new Succ(n + that)
  override def -(that: Nat): Nat = if(that.isZero) this else n - that.predecessor
}
