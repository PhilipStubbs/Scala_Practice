package lectures.part2oop

object CaseClasses extends App {


	case class Person(name: String, age: Int)

	/*	1 - class parameters are fields
		2 - sensible toString
		3 - equals and hashCode implemented Outofthebox
		4 - Case classes hs handy copy methods
		5 - case classes has companion objects
		6 - case classes are serializable
		7 - case classes have extractor patterns = CC can be used in Pattern Matching
	* */

	val mike = new Person("Mike", 34)
	println(mike.toString)
	/*println(instance) = println(instance.toString) more syntactic sugar*/
	println(mike)
	val mike2 = mike.copy()
	val thePerson = Person

	case object UK {
		def name: String = "the UL of GB and NI"
	}


}
