package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42;
  val astring: String = "hello!";

  println(x);
  println(astring);

  val bool: Boolean = true;
  val along: Float = 2.0f;

  println(along);


  var avar: Int = 4;

  println(avar);
  avar = 5;
  println(avar)
  var test: String = "test";
  println(test);

// cant overwrite var but can reassign them within the same type.
}
