package hackerrank.DaysOfCode

class Day4ClassVsInstance(initialAge: Int) {
  var age: Int = 0

  if(initialAge < 0) println("Age is not valid, setting age to 0.")
  else age = initialAge

  def amIOld(): Unit = {
    if(age < 13) println("You are young.")
    else if(age >= 13 && age < 18) println("You are a teenager.")
    else println("You are old.")
  }

  def yearPasses(): Unit = {
    age = age + 1
  }
}
