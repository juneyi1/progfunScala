package course2_week1

object random_test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  trait Generator[+T] {
    self =>

    def generate: T

    def map[S](f: T => S): Generator[S] = new Generator[S] {
      def generate = f(self.generate)
    }

    def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
      def generate = f(self.generate).generate
    }
  }

  val integers = new Generator[Int] {
    def generate = scala.util.Random.nextInt()
  }                                               //> integers  : course2_week1.random_test.Generator[Int] = course2_week1.random_
                                                  //| test$$anon$3@e580929
  val booleans = integers map (x => x > 0)        //> booleans  : course2_week1.random_test.Generator[Boolean] = course2_week1.ran
                                                  //| dom_test$Generator$1$$anon$1@48140564
	def pairs[T, U](t: Generator[T], u: Generator[U]): Generator[(T, U)] = for {
		x <- t
		y <- u
	} yield (x, y)                            //> pairs: [T, U](t: course2_week1.random_test.Generator[T], u: course2_week1.ra
                                                  //| ndom_test.Generator[U])course2_week1.random_test.Generator[(T, U)]
  def single[T](x: T) = new Generator[T] {
  		def generate = x
  }                                               //> single: [T](x: T)course2_week1.random_test.Generator[T]

	def emptyLists = single(Nil)              //> emptyLists: => course2_week1.random_test.Generator[scala.collection.immutabl
                                                  //| e.Nil.type]
	def lists: Generator[List[Int]] = for {
		isEmpty <- booleans
		list <- if (isEmpty) emptyLists else nonEmptyLists
	}	yield list                        //> lists: => course2_week1.random_test.Generator[List[Int]]
	
	def nonEmptyLists = for {
		head <- integers
		tail <- lists
	} yield head :: tail                      //> nonEmptyLists: => course2_week1.random_test.Generator[List[Int]]
	
	def test[T](g: Generator[T], numTimes: Int = 100)(test: T => Boolean): Unit = {
		for (i <- 0 until numTimes) {
			val value = g.generate
			assert(test(value), "test failed for "+value)
		}
		println("passed "+numTimes+" tests")
	}                                         //> test: [T](g: course2_week1.random_test.Generator[T], numTimes: Int)(test: T
                                                  //|  => Boolean)Unit
	test(pairs(lists, lists)) {
		case (xs, ys) => (xs ++ ys).length > xs.length
	}                                         //> java.lang.AssertionError: assertion failed: test failed for (List(),List())
                                                  //| 
                                                  //| 	at scala.Predef$.assert(Predef.scala:219)
                                                  //| 	at course2_week1.random_test$.$anonfun$main$9(course2_week1.random_test.
                                                  //| scala:46)
                                                  //| 	at scala.collection.immutable.Range.foreach$mVc$sp(Range.scala:156)
                                                  //| 	at course2_week1.random_test$.test$1(course2_week1.random_test.scala:44)
                                                  //| 
                                                  //| 	at course2_week1.random_test$.$anonfun$main$1(course2_week1.random_test.
                                                  //| scala:50)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$anonfun$$ex
                                                  //| ecute$1(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:76)
                                                  //| 	at course2_week1.random_test$.main(course2_week1.random_test.scala:3)
                                                  //| 	at course2_week1.random_test.main(course2_week1.random_test.scala)
}