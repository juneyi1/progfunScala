package week7

object generator {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  //  trait Generator[+T] {
  //    def generate: T
  //  }

  //  val integers = new Generator[Int] {
  //    val rand = new java.util.Random
  //    def generate = rand.nextInt()
  //  }

  //  val booleans = new Generator[Boolean] {
  //    def generate = integers.generate > 0
  //  }

  //	integers.generate

  trait Generator[+T] {
    self => // an alias for "this"

    def generate: T

    def map[S](f: T => S): Generator[S] = new Generator[S] {
      def generate = f(self.generate)
    }

    def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
      def generate = f(self.generate).generate
    }
  }

  val integers = new Generator[Int] {
    val rand = new java.util.Random
    def generate = rand.nextInt()
  }                                               //> integers  : week7.generator.Generator[Int]{val rand: java.util.Random} = wee
                                                  //| k7.generator$$anon$3@1cd072a9

  val booleans = for (x <- integers) yield x > 0  //> booleans  : week7.generator.Generator[Boolean] = week7.generator$Generator$1
                                                  //| $$anon$1@58ceff1

  // integers map (x => x > 0) = new Generator[Boolean] {
  //			def generate = integer.generate > 0
  // }
  // booleans.generate = integers.generate > 0

  def pairs[T, U](t: Generator[T], u: Generator[U]) = for {
    x <- t
    y <- u
  } yield (x, y)                                  //> pairs: [T, U](t: week7.generator.Generator[T], u: week7.generator.Generator
                                                  //| [U])week7.generator.Generator[(T, U)]

  // t flatMap (x => u map (y => (x, y)))
  // = t flatMap (x => new Generator[T, U] {def generate = (x, u.generate)})
  // = new Generator[T, U] {def generate = (new Generator[T, U] {def generate = (t.generate, u.generate)}).generate}
  // = new Generator[T, U] {def generate = (t.generate, u.generate)}

  pairs(integers, integers).generate              //> res0: (Int, Int) = (1746698925,-471952726)

}