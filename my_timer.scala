import scala.io.StdIn.readLine

class MyTimer{

  // TODO -
  // OnStart - Prompt for a time and a time unit
  // Take input as hour/minute/second
  // Continuously output remainder
  // Pause on any key press
  // Prompt to press any key to resume
  // End application when timer runs out

  val running : Boolean = true

  def main(args: Array[String]): Unit = {
    println("Welcome to my timer")
    println("Please enter a time input in any of the following formats")
    println("Number Unit -- 1M, 1 Minute, 2 H, 2Hours, 78s, 78 seconds")

    while(running){
      val input = GetInput()
      if(CheckUserInput(input : String)){
        println("Valid input")

      }
    }
  }
  
  def GetInput(): String = {

    val input = readLine()
    return input

  }

  def CheckUserInput(userInput : String): Boolean = {

    // Delete me
    println(f"Value passed is: $userInput")

    // Use raw to process regex without having to worry about escaping special chars
    // This breaks on 45mhs
    val AcceptablePattern = raw"(\d)+\s?([MmHhSs]+)".r

    AcceptablePattern.findFirstMatchIn(userInput) match {
      case Some(_) => println("It's a match pal")
      case None => println("No can do")
    }

    return true

  }

  def ParseUserInput(): Unit={

  }

  main(Array())


}
