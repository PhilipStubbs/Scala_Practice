package lectures.part1basics

object DefaultArgs extends  App {

	def trFact(n: Int, acc: Int = 1): Int = {
		if (n <=1 ) acc;
		else trFact(n-1, n*acc);
	}

	def test(t: Int, x: Int = 10, h: Int = 23 ): Unit = println(h);


	println(trFact(10));
	test(20, h = 10);
}
