package lectures.part2oop

object AnonClasses extends App {


	abstract class Animal {
		def eat: Unit
	}

	val funnyAnimal: Animal = new Animal {
		override def eat = println("hahah")
	}

	/*what actually happened :
	* class lectures.part2oop.AnonClasses$$anon$1 extends Animal {
	* 	override def eat = println("hahah")
	* }
	*
	* val funnyAnimal; Animal = new lectures.part2oop.AnonClasses$$anon$1
	* */

	println(funnyAnimal.getClass)

	class Person(name: String){
		def sayHi: Unit = print(s"Hi, my name is ${name}")
		def test: Unit = ???
	}

	val mike = new Person("mike") {
		override def sayHi: Unit = print(s"Hi, my name is mike, oh hi")
	}

}
