package hackerrank

import java.io._

object Solution {
  val alphabet: Seq[Char] = 'a' to 'z'
  // Complete the designerPdfViewer function below.
  def designerPdfViewer(h: Array[Int], word: String): Int = {
    val listOfValues: Seq[Int] = word.map(x => {
      h(alphabet.indexOf(x))
    })

    listOfValues.max * listOfValues.length
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val h = stdin.readLine.split(" ").map(_.trim.toInt)
    val word = stdin.readLine

    val result = designerPdfViewer(h, word)

    printWriter.println(result)

    printWriter.close()
  }
}

