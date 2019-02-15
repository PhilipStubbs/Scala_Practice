//package lectures.part3fp

object WhatsAFunction extends App {


	val doubler = new MyFunction[Int, Int] {
		override def apply(element: Int): Int = element * 2
	}

	val stringToIntConverter = new Function1[String, Int] {
		override def apply(str: String): Int = str.toInt
	}

	val adder = new Function2[Int, Int, Int] {
		override def apply(a: Int, b: Int): Int = a + b
	}

	val concat = new Function2[String, String, String] {
		override def apply(a: String, b:String): String = a + b
	}

	println(stringToIntConverter("3") + 32)
	println(concat("hello ","Friends"))

	val funOne = new Function[Int, Int] {
		override def apply(elem: Int): Int = elem
	}

	val funTwo = new Function[Int, Int] {
		override def apply(elem: Int): Int = funOne(elem)
	}

	val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
		override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
			override def apply(y: Int): Int = x + y
		}
	}

	val adder3 = superAdder(3)
	println(adder3(1))
	println(superAdder(3)(1)) // curried function
}


trait MyFunction[A, B] {
	def apply(element: A): B
}