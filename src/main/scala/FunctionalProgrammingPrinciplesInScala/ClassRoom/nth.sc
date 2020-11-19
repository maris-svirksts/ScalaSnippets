def nth[T](n: Int, l: List[T]): T = {
  if( n > l.length - 1 ) throw new IndexOutOfBoundsException
  else l(n)
}

nth(1, List(1,2,3))

def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(_) => List()
  case y :: ys => y :: init(ys)
}

def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
  case List() => throw new Error("removeAt of empty list")
  case x if x.size - 1 == n => x.init
  case y :: ys => y :: removeAt(n, ys)
}
removeAt(1, List('a', 'b', 'c', 'd')) // List(a, c, d)

val nums = List(2, -4, 5, 7, 1)
val fruits = List("apple", "pineapple", "orange", "banana")

object MergeSort {
  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length/2
    if(n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case(Nil, ys) => ys
        case(xs, Nil) => xs
        case(x :: xs1, y :: ys1) =>
          if(lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val(fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }

  def msortV1[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length/2
    if(n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case(Nil, ys) => ys
        case(xs, Nil) => xs
        case(x :: xs1, y :: ys1) =>
          if(ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val(fst, snd) = xs splitAt n
      merge(msortV1(fst), msortV1(snd))
    }
  }
}
MergeSort.msort(nums)((x: Int, y: Int) => x < y)
MergeSort.msort(fruits)((x: String, y: String) => x.compareTo(y) < 0)

MergeSort.msortV1(nums)
MergeSort.msortV1(fruits)

def squareListV1(xs: List[Int]): List[Int] =
  xs match {
    case Nil => Nil
    case y :: ys => y * y :: squareListV1(ys)
  }

def squareListV2(xs: List[Int]): List[Int] =
  xs.map(x => x * x)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: _ =>
    val( firstList, secondList ) = xs.span(y => y == x)
    firstList :: pack(secondList)
}

pack(List("a", "a", "a", "b", "c", "c", "a"))
//List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))

def encodeV1[T](xs: List[T]): List[(T, Int)] = xs match {
  case Nil => Nil
  case x :: _ =>
    val( firstList, secondList ) = xs.span(y => y == x)
    (x, firstList.length) :: encodeV1(secondList)
}
def encodeV2[T](xs: List[T]): List[(T, Int)] = {
  pack(xs).map(x => (x.head, x.length))
}
encodeV1(List("a", "a", "a", "b", "c", "c", "a"))
encodeV2(List("a", "a", "a", "b", "c", "c", "a"))
//List(List("a", 3), List("b", 1), List("c", 2), List("a", 1))

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())( ??? )

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)( ??? )

object pairs {
  def isPrime(n: Int): Boolean = (2 until n) forall ( n% _ != 0 )
  val n = 7

  (1 until n).map( i => (1 until n).map( j => (i, j))).flatten
  (1 until n).flatMap( i => (1 until n).map( j => (i, j))) forall (pair => isPrime(pair._1 + pair._2))
}

def scalarProduct(xs: List[Double], ys: List[Double]): Double = {
  (for ((x, y) <- xs.zip(ys)) yield x * y).sum
}

object nQueens {
  def show(queens: List[Int]): Unit = {
    val lines =
      for(col <- queens.reverse)
      yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString

    for(i <- 0 until lines.length) {
      println(lines(i))
    }
    println()
  }

  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val row: Int = queens.length
    val queensWithRow = (row - 1 to 0 by -1) zip queens
    queensWithRow forall {
      case(r, c) => col != c && math.abs(col - c) != row - r
    }
  }

  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] = {
      if(k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens
    }

    placeQueens(n)
  }
}

nQueens.queens(4) map nQueens.show

trait Generator[+T]{
  self =>
  def generate:T
  def map[S](f: T => S): Generator[S] = new Generator[S]{
    def generate: S = f(self.generate)
  }
  def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S]{
    def generate: S = f(self.generate).generate
  }
}

/*object generators {
  import patmat.Leaf

  val integers = new Generator[Int] {
    def generate = scala.util.Random.nextInt()
  }

  val booleans = integers.map(_ >= 0)

  def leafs: Generator[Leaf] = for {
    x <- integers
  } yield Leaf(x)

  def inners: Generator[Inner] = for {
    l <- trees
    r <- trees
  } yield Inner(l, r)

  def trees: Generator[Tree] = for {
    isLeaf <- booleans
    tree <- if(isLeaf) leafs else inners
  } yield tree
}*/