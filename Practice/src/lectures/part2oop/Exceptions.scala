package lectures.part2oop

import java.nio.BufferOverflowException

object Exceptions extends App{

	val x: String = null

//	println(x.length)
//	val aWeirdValue: String = throw new NullPointerException

	def getInt(withExceptions: Boolean): Int = {
		if (withExceptions) throw new RuntimeException("No int for you")
		else 42
	}



	val potentialFail = try {
		getInt(true)
	} catch {
		case e: RuntimeException => 52
	} finally {
		//code that will get exe no matter what
		println("finally")
	}

	println(potentialFail)
	class OverflowException extends Exception
	class UnderflowException extends Exception
	class MathCalculationException extends Exception


	def memcrash: Unit = throw new OutOfMemoryError
	def SOcrash: Unit = throw new StackOverflowError("LOL")
//	memcrash
//	SOcrash


	object PocketCalculator {

		def OFcrash: Int = throw new OverflowException
		def UFcrash: Int = throw new UnderflowException
		def MCcrash: Int = throw new MathCalculationException

		def add(x: BigInt, y:BigInt): BigInt =
		{
			if (x + y < Int.MaxValue && x + y > Int.MinValue) x + y
			else OFcrash
		}

		def subtract(x: BigInt, y:BigInt): BigInt = {
			if (x + y < Int.MaxValue && x + y > Int.MinValue) x - y
			else UFcrash
		}

		def multiply(x: BigInt, y:BigInt): BigInt = {
			if (x * y < Int.MaxValue && x * y > Int.MinValue) x * y
			else OFcrash
		}

		def divide(x: BigInt, y:BigInt): BigInt = {
			if (x != 0 && y != 0) x / y
			else MCcrash
		}
	}

	val calc = PocketCalculator
	println(calc.add(1,654654654))

}


/*
    1.  Crash your program with an OutOfMemoryError
    2.  Crash with SOError
    3.  PocketCalculator
        - add(x,y)
        - subtract(x,y)
        - multiply(x,y)
        - divide(x,y)
        Throw
          - OverflowException if add(x,y) exceeds Int.MAX_VALUE
          - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
          - MathCalculationException for division by 0
   */