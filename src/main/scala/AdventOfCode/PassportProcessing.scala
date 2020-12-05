package AdventOfCode

import scala.io.{BufferedSource, Source}

object PassportProcessing extends App {
  val getPassports: List[String]    = Source.fromFile("src/main/scala/AdventOfCode/PassportProcessing.txt").mkString.split("\\n\\n").toList
  val passwordBaseLine: Set[String] = Set("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid")
  val NPBaseLine: Set[String]       = Set("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

  val results_p1 = for{
    passport: String <- getPassports
    passwordFields: Set[String] = passport.split("\\n").flatMap(x => x.split("\\s+")).map(x => x.split(":", 2).head).toSet
    if passwordBaseLine.equals(passwordFields) || NPBaseLine.equals(passwordFields)
  } yield passwordFields

  println("result List: " + results_p1)
  println("result Count: " + results_p1.length)

  val results_p2 = for{
    passport: String <- getPassports
    passwordFields: Map[String, String] = passport.split("\\n")
                      .toList.flatMap(x => x.split("\\s+").toList)
                      .map(x => x.split(":", 2)).map(y => {y.head -> y.last}).toMap
    if(passwordFields.getOrElse("byr", "0").toInt >= 1920) && (passwordFields.getOrElse("byr", "0").toInt <= 2002)
    if(passwordFields.getOrElse("iyr", "0").toInt >= 2010) && (passwordFields.getOrElse("iyr", "0").toInt <= 2020)
    if(passwordFields.getOrElse("eyr", "0").toInt >= 2020) && (passwordFields.getOrElse("eyr", "0").toInt <= 2030)
    if passwordFields.getOrElse("hgt", "0").matches("^(1(([5-8][0-9])|(9[0-3]))cm)|((59|(6[0-9])|(7[0-6]))in)$")
    if passwordFields.getOrElse("hcl", "0").matches("^#([0-9]|[a-f]){6}$")
    if passwordFields.getOrElse("ecl", "0").matches("^(amb|blu|brn|gry|grn|hzl|oth)$")
    if passwordFields.getOrElse("pid", "0").matches("^[0-9]{9}$")
  } yield passwordFields

  println("result List: " + results_p2)
  println("result Count: " + results_p2.length)
}
