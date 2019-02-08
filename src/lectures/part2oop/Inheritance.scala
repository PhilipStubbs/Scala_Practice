package lectures.part2oop

object Inheritance extends App {

	/* single class inheritace */
	sealed class Animal {
		val creatureType = "wild"
		private def food = println("nom nom nom")
		def eat() = println(s"nom nom nom")

//		final def eat()  = println(s"nom nom nom")
	}

	class Cat extends Animal {

		def crunch = {
			eat
			println("crunch crunch")
		}
	}

	val cat = new Cat

//	cat.crunch

	/*constructors*/
	class Person(name: String, age : Int) {
		def this(name:String) = this(name, 0)
	}
	/*
	 the following wont work because it calls the constructor of the super class first.
		class Adult(name: String, age: Int, idCard: String) extends Person
	*/
	class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

	/*
	overriding
		class Dog(override val creatureType: String) extends Animal {		// can do overriding in the constructor
			override def eat() = println(s"Im a dog barkbark nom nom")
		}
	*/

	class Dog(Type: String) extends Animal {
		override val creatureType = Type
		override def eat() = {
//			super.eat
			println(s"Im a dog barkbark nom nom")
		}
	}

	val dog = new Dog("k9")
	dog.eat


	/*
	 type substitution (Broad: Polymorphism)
	*/


//	val unknownAnimal: Animal = new Dog("K9")
//		unknownAnimal.eat

	/*
	overRiding vs overLoading

	super
		 used when you want to use/referance a method from a super class
	*/


	/*	preventing overrides
	* 	1 - use 'final'
	* 	2 - use 'final' on the entire class
	* 	3 - 'seal' the class = can extend classes in THIS file, but prevent extension in other files
	*
	* */
}
