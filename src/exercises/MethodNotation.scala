package exercises

object MethodNotation extends App{
	class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
		def likes(movie: String): Boolean = {movie == favoriteMovie}
		def hangingOutwith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
		def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
		def unary_! : String = s"$name, oh wow!"
		def isAlive: Boolean = true
		def apply(): String = s"Hi, my name is ${name} and my fav movie is ${favoriteMovie}"

		def +(nickname: String): Person = new Person( s"${this.name} (${nickname}", this.favoriteMovie, this.age)

		def learns(item: String): String = {
			s"${this.name} learns ${item}"
		}
		def learnScala: String = {
			learns("Scala")
		}
		def unary_+ : Person = new Person (name, favoriteMovie, age + 1)

		def apply(n: Int): String = s"${name} watched ${favoriteMovie} ${n} times"
	}

	val mike = new Person("Mike", "How To Train Your Dragon", 25)

	println(mike(3))
	val test = (+mike).age
	println(test)
	println(mike learnScala)

}
