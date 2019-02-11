package lectures.part1basics

object Expressions extends App{
  val x : Int = 1 + 2;

  val con: Boolean = false;

//  val test: String = if(con) "hellow" else "world";
 if (con)
    {
      "it is true!"
      println("here true")
    }
  else
  {
    "it is false!"
    println("here false")
  }

  var test = if (con) "oh!" else "hi!"
  println(test);

  var aVariable = 1;

  val aWeirdValue = (aVariable = 3);
  println(aWeirdValue);

  val aclodebloc = {
    val y = 2;
    var z = y+1;

    if (z > 2)
      {
        "hello"
      }
    else
      {
        "goodbye"
      }
  }

  val testblock_1 = {
    2 < 3;
  }

  val testblock_2 = {
    if (testblock_1) 232 else 989;
  }


  println(aclodebloc);
  println(testblock_2);
}
