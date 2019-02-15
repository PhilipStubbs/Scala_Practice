package lectures.part3fp

object MapFlatmapFilerFor extends App{

	val list = List(1,2,3)
	println(list)

	println(list.map(_ + 1))
	println(list.map(_ + " is a number"))

	val numbers = List(1,2,3,4)
	val chars = List('a','b','c','d')

	val colors = List("Black", "while", "Blue")

	val combo = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))

	println(combo)

	val forCombo = for {
		n <- numbers if n % 2 == 0
		c <- chars
		color <- colors
	} yield "" + c + n + "-" + color

	println(forCombo)
}
