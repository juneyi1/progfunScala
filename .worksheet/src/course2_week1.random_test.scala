package course2_week1

object random_test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(87); 
  println("Welcome to the Scala worksheet")
  
  trait Generator[+T] {
    self =>

    def generate: T

    def map[S](f: T => S): Generator[S] = new Generator[S] {
      def generate = f(self.generate)
    }

    def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
      def generate = f(self.generate).generate
    }
  };$skip(390); 

  val integers = new Generator[Int] {
    def generate = scala.util.Random.nextInt()
  };System.out.println("""integers  : course2_week1.random_test.Generator[Int] = """ + $show(integers ));$skip(43); 
  val booleans = integers map (x => x > 0);System.out.println("""booleans  : course2_week1.random_test.Generator[Boolean] = """ + $show(booleans ));$skip(112); 
	def pairs[T, U](t: Generator[T], u: Generator[U]): Generator[(T, U)] = for {
		x <- t
		y <- u
	} yield (x, y);System.out.println("""pairs: [T, U](t: course2_week1.random_test.Generator[T], u: course2_week1.random_test.Generator[U])course2_week1.random_test.Generator[(T, U)]""");$skip(68); 
  def single[T](x: T) = new Generator[T] {
  		def generate = x
  };System.out.println("""single: [T](x: T)course2_week1.random_test.Generator[T]""");$skip(31); 

	def emptyLists = single(Nil);System.out.println("""emptyLists: => course2_week1.random_test.Generator[scala.collection.immutable.Nil.type]""");$skip(130); 
	def lists: Generator[List[Int]] = for {
		isEmpty <- booleans
		list <- if (isEmpty) emptyLists else nonEmptyLists
	}	yield list;System.out.println("""lists: => course2_week1.random_test.Generator[List[Int]]""");$skip(86); 
	
	def nonEmptyLists = for {
		head <- integers
		tail <- lists
	} yield head :: tail;System.out.println("""nonEmptyLists: => course2_week1.random_test.Generator[List[Int]]""");$skip(236); 
	
	def test[T](g: Generator[T], numTimes: Int = 100)(test: T => Boolean): Unit = {
		for (i <- 0 until numTimes) {
			val value = g.generate
			assert(test(value), "test failed for "+value)
		}
		println("passed "+numTimes+" tests")
	};System.out.println("""test: [T](g: course2_week1.random_test.Generator[T], numTimes: Int)(test: T => Boolean)Unit""");$skip(81); 
	test(pairs(lists, lists)) {
		case (xs, ys) => (xs ++ ys).length > xs.length
	}}
}
