import scala.concurrent.Future
import scala.io.StdIn.readLine
import scala.util.{Success, Failure}


class MyTimer{

  var running : Boolean = true

  def main(args: Array[String]): Unit = {
    println("\nWelcome to my timer")
    println("Please enter a time input in any of the following formats")
    println("Number Unit -- 1M, 1 Minute, 2 H, 2Hours, 78s, 78 seconds")
    println("Input a 'q' to quit and exit the program.")

    // Main REPL
    while(running){
      var input = readLine()

      if(CheckUserInput(input : String)){
        //println(f"Valid input: $input")
        var timerParams = ParseUserInput(input)
        println(f"I will now start a timer for $timerParams seconds")
        StartTimer(timerParams)
        input = "q"
        print("Timer successfully finished, exiting application.")
      }

      // User wants to quit the application
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

    var lowerCaseUserInput = userInput.toLowerCase()

    // Use raw to process regex without having to worry about escaping special chars
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
      numSeconds = lowerCaseInput.slice(0, secondsStartLocation).toInt
      return numSeconds
    }

    // minute
    val minutesStartLocation = lowerCaseInput.indexOf("m")
    if (minutesStartLocation != -1){
      numSeconds = (lowerCaseInput.slice(0, minutesStartLocation).toInt * 60)
      return numSeconds

    }

    // hours
    val hoursStartLocation = lowerCaseInput.indexOf("h")
    if (hoursStartLocation != -1){
      numSeconds = (lowerCaseInput.slice(0, hoursStartLocation).toInt * 60 * 60)
      return numSeconds
    }

    return numSeconds
  }

  def StartTimer(number : Int) : Unit = {
    var paused = false
    var numSeconds = number

    // Asynch callback on any keypress
    // Compiler seems to throw an error unless this is imported here
    // Are imports supposed to be at the top of a class or is this considered okay?
    import scala.concurrent.ExecutionContext.Implicits.global
    val f: Future[Int] = Future {
      System.in.read()
    }
    f onComplete {
      case Success(posts) => {
        //println(f"That was a successfull callback")
        paused = true
      }
      case Failure(t) => println("Something has gone wrong")
    }

    while(numSeconds > 0 && !paused){
      // Output remaining time
      println(f"There are $numSeconds seconds left")
      println("Press any key to pause timer.")
      println("-------------")

      // Decrement seconds remaining
      numSeconds = numSeconds - 1;
      // Sleep for one second
      Thread.sleep(1000)

      // Asynch callback listens for keypress and sets paused to true when it happens
      while(paused){
        // Prompt user to unpause
        println(f"Pausing timer at $numSeconds seconds remaining")
        println("Press any key to resume timer.")
        println("-------------")
        // Wait for unpause (any key)
        System.in.read()
        println("Resuming timer")
        println("-------------")
        paused = false
        StartTimer(numSeconds)
      }
    }

    // This ends the execution and causes the program to eventually exit
    running = false

  }

  main(Array())
}
