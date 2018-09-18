import scala.io.StdIn.readLine

class MyTimer{

  // TODO -
  // OnStart - Prompt for a time and a time unit
  // Take input as hour/minute/second
  // Continuously output remainder
  // Pause on any key press
  // Prompt to press any key to resume
  // End application when timer runs out

  var running : Boolean = true

  def main(args: Array[String]): Unit = {
    println("Welcome to my timer")
    println("Please enter a time input in any of the following formats")
    println("Number Unit -- 1M, 1 Minute, 2 H, 2Hours, 78s, 78 seconds")
    println("Input a 'q' to quit and exit the program.")

    // Main REPL
    while(running){
      var input = readLine()

      if(CheckUserInput(input : String)){
        println(f"Valid input: $input")
        var timerParams = ParseUserInput(input)
        StartTimer(timerParams)
      }

      if(input == "q"){
        println("Exiting timer")
        running = false
      }

      else if(!CheckUserInput(input : String)){
        println("I don't recognize that input, please try again")
      }

      println("-------------")

    }
  }

  def CheckUserInput(userInput : String): Boolean = {
    // Use raw to process regex without having to worry about escaping special chars
    // This breaks on 45mhs
    val AcceptablePattern = raw"(\d)+\s?([MmHhSs]+)".r

    AcceptablePattern.findFirstMatchIn(userInput) match {
      case Some(_) => return true
      case None => return false
    }
  }

  def ParseUserInput(userInput : String): Int = {
    var numSeconds : Int = 0
    var lowerCaseInput = userInput.toLowerCase()

    // seconds
    val secondsStartLocation = lowerCaseInput.indexOf("s")
    if (secondsStartLocation != -1){
      // Delete me?
      numSeconds = lowerCaseInput.slice(0, secondsStartLocation).toInt
      return numSeconds
    }

    // minute
    if (lowerCaseInput.indexOf("m") != -1){
      // Delete me
      println("minutes")
      return numSeconds

    }

    // hours
    if (lowerCaseInput.indexOf("h") != -1){
      // Delete me
      println("hours")
      return numSeconds
    }

    return numSeconds
  }

  def StartTimer(numSeconds : Int) : Unit = {
    var paused : Boolean = false
    while(numSeconds > 0){
      while(!paused){
        
      }
    }
  }




  main(Array())


}
