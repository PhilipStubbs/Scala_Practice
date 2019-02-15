package lectures.part3fp

object AnonymousFunction extends App {

	// anonymous function (Lambda)
	val doubler = (x: Int) => x * 2

	val doubler1: Int => Int = (x: Int) => x * 2

	val doubler2: Int => Int = x => x * 2		// if Int arrow Int dont need to specify x type

	val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

	val justDoSeomthing:() => Int = () => 3

	// careful. you must use () with anon function/Lambda
	println(justDoSeomthing)	// function itself
	println(justDoSeomthing())	// call

	val stringToInt = { (str: String) =>
		str.toInt
	}

	// More Syntactic sugar

	val niceIncrementer: Int => Int = _ + 1		// equivalent to x => x + 1

	val niceAdder: (Int, Int) => Int = _ + _	// equivalent to (a,b) => a + b

//	val superAdder: (Int, Int ) => Int = (x: Int , y: Int => Int) => {
//
//	}
	val superAdder = (x: Int ) => (y: Int) => x + y




	println(superAdder)
	println(superAdder(2)(4))


	/*
		val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
			override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
				override def apply(y: Int): Int = x + y
			}
		}
	*/
}
