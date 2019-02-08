package lectures.part2oop

import java.util.Calendar

object OOBasics extends App{

	val person = new Person("Philip", 25)
//	println(person.age)
//	println(person.x)
//	person.greet("K")
	val writer = new Writer("Philip", sirname = "Stubbs", 1994)
	val book = new Novel("Scala Practice", 2019, writer)
	val newbook = book.copy(2001)

	println(book.authorAge())
	println(book.isWrittenBy())

	val counter = new Counter()
	counter.inc.inc.inc.print;
	counter.inc(10).print;

//	println(newbook.isWrittenBy());
}


class Person (name: String, val age: Int) // constructor add val/var to be able to use it as a field
{
	//body
	var x = 2
	println("hello")

	def greet(name : String): Unit = println(s"${this.name} says hi!, $name")

	// overloading
	def greet(): Unit = print(s"Hi, I am $name")
	def greet(hello: Int): Int = 42;

	//multiple constructor
	def this(name: String) = this(name, 0)
}

class Writer (name: String, sirname: String, val birth: Int){

	def fullname: String =
	{
		this.name+" "+this.sirname
	}

}

class Novel (name: String, release: Int, author: Writer){

	def authorAge(): Int = {
		val cal = Calendar.getInstance()
		val year = cal.get(Calendar.YEAR)
		year - author.birth;
	}

	def isWrittenBy(): String ={
		 author.fullname + " year: " + this.release
	}

	def copy(year: Int): Unit =
	{
		new Novel(this.name, year, this.author)
	}

}



class Counter(val count: Int = 0)
{
	def inc = {
		println("inc")
		new Counter(count + 1) //immutability
	}
	def dec = {
		println("dec")
		new Counter(count - 1)
	}

	def inc(n : Int): Counter = {
		if (n <= 0) this
		else inc.inc((n-1))
	}
	def dec(n: Int): Counter = {
		if (n <= 0) this
		else dec.dec(n-1)
	}

	def print = println(count)
}
//call parameters are Not Fields