package lectures.part1basics

object StringOps extends App{

	val str: String = "Hello, I am learning Scala"

	println(str.charAt(4))
	println(str.substring(7, 11))
	println(str.split(" ").toList)
	println(str.startsWith("Hello"))
	println(str.replace(" ", "-"))
	println(str.toLowerCase())
	println(str.toUpperCase())
	println(str.length())

	val numstr = "45"
	val num = numstr.toInt

	println('a' +: numstr :+ 'z')
	println(str.take(3))

	// s-interpolators

		val name = "Philip"
		val age = 22
		val greeting = s"Hello, my name is $name and I am ${age + 3}"
		println(greeting)

	// F-interpolators	Can use printf syntax in println
		val speed = 1.2f
		val myth = f"$name can eat $speed%2.2f"
		println(myth);

	// raw-interpolator
		println(raw"this is a \n newline")
		val escaped = "this is a \n newline"
		println(raw"$escaped")



}

