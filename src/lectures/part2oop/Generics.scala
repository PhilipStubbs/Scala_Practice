package lectures.part2oop

object Generics extends App{

	class MyList[A] {		//generic class
		//use type A, is generic
	}

	trait Traitlist[A]

	class MyMap[Key, Value]

	val listOfInt = new MyList[Int]
	val listOfStr = new MyList[String]

	object MyList {
		def empty[A]: MyList[A] = ???
	}
	val emptyListOfInt = MyList.empty[Int]

	// variance problem

	class Animal
	class Cat extends Animal
	class Dog extends Animal

	/*1 - yes list[cat] extends list[animal] = COVARIANCE*/
	class CovariantList[+A]

	val animal: Animal = new Cat
	val animalList: CovariantList[Animal] = new CovariantList[Cat]

	/* animalList.add(new Dog)? HARD QUESTION */

	/*2 - No = Invariance*/
	class InvariantList[A]
	val invariantAnimalList : InvariantList[Animal] = new InvariantList[Animal]

	/*3 - Hell, no! Contravariance */
	class ContravarianceList[-A]
	val contravariantList: ContravarianceList[Cat] = new ContravarianceList[Animal]


	class Trainer[-A]
	val Trainer: Trainer[Cat] = new Trainer[Animal]



}
