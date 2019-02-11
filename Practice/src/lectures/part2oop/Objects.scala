package lectures.part2oop

object Objects {


	// Does Not Have Class-level functionality ("Static")

	object Person {			// type + its only instance
		val N_EYES = 2
		def canFly: Boolean = false


	// Factory Method
		def apply(mother: Person, father: Person): Person = new Person("Bobby")
	}
	class Person(val name : String) {
		// instance-level functionality

	}

	def main(args: Array[String]): Unit = {
		// Companions ^

			println (Person.N_EYES)
			println (Person canFly)

			// object = singleton instance
			val mary = new Person ("Mary")
			val john = new Person ("John")

			val bobby = Person (mary, john)
	}

	// Scala Application = Scala object with
	// def main(args: Array[String]): Unit
	// if no def main, your object needs to extend App since App has a main

}
