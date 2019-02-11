package lectures.part2oop

object AbstractDataTypes extends App {

	// abstract

	abstract class Animal {

		val creatureType : String = "K9"// val is abstract, has no value yet
		def eat: Unit // no implementation - abstracted

		// used if you want the subclasses to implement them for you
		// abstract classes can be an instance
	}

	class Dog extends Animal {
		override val creatureType: String = "K9"
		/* dont need the override because its abstracted */
		def eat: Unit = println("crunch crunch")
	}

	// traits
	trait Carnivore {
		def eat(animal: Animal): Unit
		val preferredMeal: String = "fresh meat"
	}

	trait ColdBlooded

	class Crocodile extends Animal with Carnivore with ColdBlooded {
		override val creatureType: String = "croc"
		def eat: Unit = println("nomnomnom")
		def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
	}

	val dog = new Dog
	val croc = new Crocodile
	croc.eat(dog)

	/*Traits vs Abstract classes
	* 1 - traits do not have constructor parameters
	* 2 - you can only extend ONE class, but can have multiple traits
	* 3 - traits = behavior, abstract class = "thing"
	*/
}
