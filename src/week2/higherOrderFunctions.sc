package week2

object excercise2 {
  //println("Welcome to the Scala worksheet")
  def sum(f: Int => Int, a: Int, b: Int) = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1 , f(a) + acc)
    }
    loop(a, 0)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  sum( x => x * x, 3, 5)                          //> res0: Int = 50
}