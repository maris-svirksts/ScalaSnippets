import cats._
import cats.implicits._

case class OptionT[F[_], A](value: F[Option[A]])

Monad[Option].ifM(Option(true))(Option("truthy"), Option("falsy"))
Monad[List].ifM(List(true, false, true))(List(1, 2), List(3, 4))

Foldable[List].foldLeft(List(1, 2, 3), 0)(_ + _)

val lazyResult =
  Foldable[List].foldRight(List(1, 2, 3), Now(0))((x, rest) => Later(x + rest.value))
lazyResult.value

Foldable[List].fold(List("a", "b", "c"))
Foldable[List].fold(List(1, 2, 3))

Foldable[List].foldMap(List("a", "b", "c"))(_.length)
Foldable[List].foldMap(List(1, 2, 3))(_.toString)

Foldable[List].foldK(List(List(1, 2), List(3, 4, 5)))
Foldable[List].foldK(List(None, Option("two"), Option("three")))

Foldable[List].find(List(1, 2, 3))(_ > 2)
Foldable[List].find(List(1, 2, 3))(_ > 5)

Foldable[List].exists(List(1, 2, 3))(_ > 2)
Foldable[List].exists(List(1, 2, 3))(_ > 5)

Foldable[List].forall(List(1, 2, 3))(_ <= 3)
Foldable[List].forall(List(1, 2, 3))(_ < 3)

Foldable[List].toList(List(1, 2, 3))
Foldable[Option].toList(Option(42))
Foldable[Option].toList(None)

Foldable[List].filter_(List(1, 2, 3))(_ < 3)
Foldable[Option].filter_(Option(42))(_ != 42)

def parseInt(s: String): Option[Int] =
  Either.catchOnly[NumberFormatException](s.toInt).toOption

Foldable[List].traverse_(List("1", "2", "3"))(parseInt)
Foldable[List].traverse_(List("a", "b", "c"))(parseInt)

val FoldableListOption = Foldable[List].compose[Option]
FoldableListOption.fold(List(Option(1), Option(2), Option(3), Option(4)))
FoldableListOption.fold(List(Option("1"), Option("2"), None, Option("3")))

Foldable[List].isEmpty(List(1, 2, 3))
Foldable[List].dropWhile_(List(1, 2, 3))(_ < 2)
Foldable[List].takeWhile_(List(1, 2, 3))(_ < 2)