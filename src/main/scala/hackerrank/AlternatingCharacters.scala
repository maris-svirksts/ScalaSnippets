package hackerrank

// https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

object AlternatingCharacters {

  // Complete the alternatingCharacters function below.
  def alternatingCharacters(s: Array[Char]): Int = {
    val unedited = s.length

    val edited: Int = s.foldLeft(Array[Char]())((sum, element) => {
      if(sum.lastOption.getOrElse('C') == element) sum
      else sum.appended(element)
    }).length

    unedited - edited
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val q     = stdin.readLine.trim.toInt

    for { _ <- 1 to q } yield println(alternatingCharacters(stdin.readLine.toArray))
  }
}

