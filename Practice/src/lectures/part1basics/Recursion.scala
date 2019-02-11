package lectures.part1basics
import scala.annotation.tailrec

object Recursion extends App {


//	@tailrec
//	def fac(n: Int): Int = {
//
//		if (n <= 1) 1
//		else {
//			println("computing "+ n + " but i first need "+ (n -1))
//			n * fac(n - 1);
//		}
//
//	}

	def anothfac(n: Int): BigInt = {

		def facthelper(x: Int, accum: BigInt): BigInt = {
			if (x <= 1 ) accum
			else facthelper(x - 1, x * accum);
		}
		facthelper(n, 1);
	}

	@tailrec
	def concat(str: String, n: Int, ret : String): String = {
		if (n <= 1) ret;
		else
		{
			concat((str), (n - 1), (str+ret));
		}
	}


	def isPrime(n:Int ):Boolean = {
		@tailrec
		def isPrimeUntil(ori: Int, t: Int, accum: Int ): Boolean =
		{
			if (t <=1) true;
			else
			{
				ori % t != 0 &&	isPrimeUntil(n, t-1, 1);
			}
		}
		isPrimeUntil(n, n/2,1);
	}

		@tailrec
		def feb(t: BigInt, c: BigInt = 1, accum: BigInt = 1): BigInt = {
			if (t <= 0) accum
			else
			{
				feb(t-1, t-1, (accum * t));
			}
		}


	def febOri(n: BigInt): BigInt = {
		if (n <= 0) 1 else n * febOri((n-1));
	}



	println(concat("Hello!", 10, ""))
	println(isPrime(2003));
	println(isPrime(629));
	println(febOri(8));
	println(feb(8));
}
