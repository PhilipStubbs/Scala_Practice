package lectures.part2oop

object MethodNotation extends App {

	class Person(val name: String, favoriteMovie: String) {
		def likes(movie: String): Boolean = {movie == favoriteMovie}
		def hangingOutwith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
		def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
		def unary_! : String = s"$name, oh wow!"
		def isAlive: Boolean = true
		def apply(): String = s"Hi, my name is ${name} and my fav movie is ${favoriteMovie}"
	}

	// infix notation / operator notation. (syntactic sugar)
	// All operators are methods

	// prefix notation
	println("\n 	prefix notation: ")

	val mary = new Person("Mary", "Inception")
	val mike = new Person("Mike", "How to train your dragon")
	println(mary.likes("Inception"))
	println(mary likes "Inception")
	println(mike hangingOutwith mary)
	println(mike + mary)

	println(1 + 2)
	println(1.+(2))

	val x = -1 // equivalent with 1.unary_-
	val y = 1.unary_-

	println(!mary)
	println(mary.unary_!)
	// unary_ prefix only works with - + ~ !


	//postfix notation
	println("\n 	postfix notation:")
	println(mary.isAlive)
	println(mary isAlive)
	// has to take no param

	// apply (special method)
	println("\n 	apply:")
	println(mary.apply())
	println(mary())
}
