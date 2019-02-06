package lectures.part1basics

object functions extends App {

	def afunction(a: String,b : Int): String = {
	a + " " + b
	}

	def parfun(): String = {
		"oh hi";
	}

	def aRepeater(str: String, n: Int): String = {
		if (n == 1){
		  str;
		}
		else
		{
		  str + aRepeater(str, n-1);
		}
	}

	def greeting(name: String, age: Int) = println("Hi, my name is " + name + " and I am " + age);


	def fact(n: Int, i: Int = 1): Int = {

		var ret: Int = i +1;
		if (n >= i)
		{
			if (n % i == 0)
			{
				println(i);
			}
			fact(n , ret);
		}
	0
	}

	def feb(n: Int): Int = {
		if (n <= 0) 1 else n * feb((n-1));
	}
	
	

	def isPrime(n:Int ): Boolean = {
		def isPrimeUnit(t: Int):Boolean = {
			if (t <=1 ) true
			else  n % t != 0 && isPrimeUnit((t-1));
		}
		isPrimeUnit(n / 2);
	}

	println(feb(10));

	println(isPrime(11));

	var t: Int = 10;
	fact(t);
	println();
}















