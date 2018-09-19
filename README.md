# Repository for learning Scala.


## Here's an overview for how my code works
  1. Create a class called MyTimer.
  2. Create a boolean variable for running to keep track of the status.
  3. Prompt the user for a time Input.
  4. Take that input and check that it matches the desired format using regex.
  5. Parse out the desired unit and value using String.slice, convert to a total number of seconds to count.
  6. Create an Asynchronous callback to allow the user to pause the timer at any time
# Repository for learning Scala.


## Here's an overview for how my code works
  1. Create a class called MyTimer.
  2. Create a boolean variable for running to keep track of the status.
  3. Prompt the user for a time Input.
  4. Take that input and check that it matches the desired format using regex.
  5. Parse out the desired unit and value using String.slice, convert to a total number of seconds to count.
  6. Create an Asynchronous callback to allow the user to pause the timer at any time

## Concerns/Troubles
  1. The way I was able to get this working was by running the following commands
  spark-shell
  :load MyTimer.scala (from its directory)
  instantiate -> val myTimer = new MyTimer()
  Console output starts and asks user for input
  2. I feel that my method of using an async callback to allow the user to pause execution of the timer is a little 'hacky' but I couldn't find a better way of taking input without also needing the user to hit the enter key. Given the application parameters of pausing/unpausing on any key press I didn't feel the user should have to hit enter on top of any key in order to pause execution so I went with an async callback as my solution. I'd love to get feedback on other possibilities available in Scala that I may not know yet.

  3. If you repeatedly press a given key fast enough during a timer, the output starts looking weird, I'm almost certain this is due to some sort of race condition happening with the async callback.

  4. The callback is instantiated on each instance of the main timer loop, I would imagine this creates a lot of overhead. If I have the callback instantiated outside of that loop the user is only able to pause/unpause one or two times before the output starts to break.

  5. When entering values, what you type is not updated to the console. The correct values are parsed and the appropriate duration is timed, however it shows up invisible while you type it on my console/environment.


## Here's a summary of some things I learned or found notable
  I really like the flexibility of being able to assign a type to an object when you instantiate.

  Spark utilizes an RDD - Resilient  Distributed Dataset. It distributes data across multiple nodes, copies data to be fault tolerant, and partitions the data, allowing parallel operations.

  Scala allows the direct import and use of Java libraries.

  Scala didn't like to run when pointed to newer version of Java, I had to ensure I was using JDK8

  I really like that when you're running code from the command line it assigns a res value to the output of your expressions and allows you to easily pass those results to newer expressions as needed.

## Concerns/Troubles
  The way I was able to get this working was by running the following commands
  spark-shell
  :load MyTimer.scala (from its directory)
  instantiate -> val myTimer = new MyTimer()
  Console output starts and asks user for input
  ------------------------------------------------------------------------------------------
  I feel that my method of using an async callback to allow the user to pause execution of the timer is a little 'hacky' but I couldn't find a better way of taking input without also needing the user to hit the enter key. Given the application parameters of pausing/unpausing on any key press I didn't feel the user should have to hit enter on top of any key in order to pause execution so I went with an async callback as my solution. I'd love to get feedback on other possibilities available in Scala that I may not know yet.

  If you repeatedly press a given key fast enough during a timer, the output starts looking weird, I'm almost certain this is due to some sort of race condition happening with the async callback.

  The callback is instantiated on each instance of the main timer loop, I would imagine this creates a lot of overhead. If I have the callback instantiated outside of that loop the user is only able to pause/unpause one or two times before the output starts to break.
  ------------------------------------------------------------------------------------------
  When entering values, what you type is not updated to the console. The correct values are parsed and the appropriate duration is timed, however it shows up invisible while you type it on my console/environment.


## Here's a summary of some things I learned or found notable
  I really like the flexibility of being able to assign a type to an object when you instantiate.

  Spark utilizes an RDD - Resilliant Distributed Dataset. It distributes data across multiple nodes, copies data to be fault tolerant, and partitions the data, allowing parallel operations.

  Scala allows the direct import and use of Java libraries.

  Scala didn't like to run when pointed to newer version of Java, I had to ensure I was using JDK8

  I really like that when you're running code from the command line it assigns a res value to the output of your expressions and allows you to easily pass those results to newer expressions as needed.
