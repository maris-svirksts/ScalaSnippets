def nth[T](n: Int, l: List[T]): T = {
  if( n > l.length - 1 ) throw new IndexOutOfBoundsException
  else l(n)
}

nth(1, List(1,2,3))