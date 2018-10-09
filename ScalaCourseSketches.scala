// Check an input int is even
def checkEven(num:Int) Boolean = {
	return num%2==0
}

println(checkEven(4))
println(checkEven(7))


// Check a list contains only even values
def checkList(numbers:List[Int]): Boolean = {
	for(n <- numbers){
		if(n%2==2){
			return true
		}
	}
	return false
}

val evenSample = List(1,2,3,4,5)
val oddSample = List(3,5,7,89)

println(checkList(evenSample))
println(checkList(oddSample))


// Sum a list of numbers, but add any 7s in the list twice 
def lucky(nums:List[Int]): Int = {
	var output = 0

	for(n <- nums){
		if(n==7){
			output = output + 14
		}
		else{
			output = output + n
		}
	}
	return output
}

val numbers = List(1,2,3,7)
println(lucky(numbers))


// Check if a list is evenly sized
def balanceCheck(mylist:List[Int]): Boolean = {
	var firsthalf = 0
	var secondhalf = 0

	secondhalf = mylist.sum

	for(i <- Range(0, mylist.length)){
		firsthalf = firsthalf + mylist(i)
		secondhalf = secondhalf - mylist(i)

		if(firsthalf == secondhalf){
			return true
		}
	}

	return false
}

val balancedList = List(1,2,3,4,5,6)
val unBalancedList = List(1,2,3)

println(balanceCheck(balancedList))
println(balanceCheck(unBalancedList))

// Palindrome check
def palindromeCheck(st:String): Boolean = {
	return (st==st.reverse)
}

println(palindromeCheck("abccba"))
println(palindromeCheck("abaa"))