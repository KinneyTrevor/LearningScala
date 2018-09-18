import scala.io.StdIn.readLine

class MyTimer{

  // TODO -
  // OnStart - Prompt for a time and a time unit
  // Take input as hour/minute/second
  // Continuously output remainder
  // Pause on any key press
  // Prompt to press any key to resume
  // End application when timer runs out

  def MyTimer(){
    println("Welcome to my timer")
    val input = readLine("Please enter a time input: \n")
    println(f"Your string is: $input")
    check_user_input(input)
  }

  def CheckUserInput(val userInput : String){
    println(f"Value passed is: $userInput" )

  }


}
