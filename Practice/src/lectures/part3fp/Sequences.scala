package lectures.part3fp

import scala.util.Random

object Sequences extends App {

	val asequnece = Seq(1,2,3,4)
	println(asequnece)

	val aList = List(1,2,3)
	val prepended = 42 :: aList
	println(prepended)
	val apples5 = List.fill(5)("apple")
	println(apples5)
	println(aList.mkString("-|-"))

	val number = Array(1,2,3,4)
	val threeElements = Array.ofDim[Int](3)
	threeElements.foreach(println)

	number(2) = 0
	println(number.mkString(" "))

	val numbersSeq: Seq[Int] = number
	println(numbersSeq)

	val vector: Vector[Int] = Vector(1,2,3)
	println(vector)


	val maxRuns = 1000
	val maxCap = 1000000
	def getWriteTime(coll: Seq[Int]): Double = {
		val r = new Random
		val times = for (
			it <- 1 to maxRuns
		) yield {
			val currentTime = System.nanoTime()
			coll.updated(r.nextInt(maxCap), r.nextInt())
			System.nanoTime() - currentTime
		}
		times.sum * 1.0 / maxRuns
	}

	val numberList = (1 to maxCap).toList
	val numberVector = (1 to maxCap).toVector

	println("Link : " + getWriteTime(numberList))
	println("Vect : " + getWriteTime(numberVector))
}
