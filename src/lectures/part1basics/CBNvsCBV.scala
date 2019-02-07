package lectures.part1basics

object CBNvsCBV extends App {

	def callByValue(x: Long): Unit = {
		println("by value: " + x);
		println("by value: " + x);
	}

	def callByName(x: => Long): Unit = {
		println("by name: " + x);
		println("by name: " + x);
	}

	def infinite(): Int = 1 + infinite();
	def printFirst(x: Int, y: => Int) = println(x);

	callByValue(System.nanoTime());
	callByName(System.nanoTime());

//	printFirst(infinite(), 34);				//infinite will crash, the '=>' Will delay the call until it is used.
	printFirst(34, infinite());

	/*
		Call By Value:
					Value is computed before the call
					same value is used throughout the function

		Call by Name:
					looks like " => "
					Not a value, but the expression it self.
					evaluated every time it is used. So it can and will change.
	*/

}
