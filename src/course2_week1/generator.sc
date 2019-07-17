package course2_week1

object generator {
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
  }                                               //> integers  : course2_week1.generator.Generator[Int] = course2_week1.generator
                                                  //| $$anon$3@1cd072a9

  val booleans = integers map (x => x > 0)        //> booleans  : course2_week1.generator.Generator[Boolean] = course2_week1.gener
                                                  //| ator$Generator$1$$anon$1@58ceff1

  trait Tree

  case class Inner(left: Tree, right: Tree) extends Tree

  case class Leaf(x: Int) extends Tree

  def leafs: Generator[Leaf] = for {
    x <- integers
  } yield Leaf(x)                                 //> leafs: => course2_week1.generator.Generator[course2_week1.generator.Leaf]

  def inners: Generator[Inner] = for {
    l <- trees
    r <- trees
  } yield Inner(l, r)                             //> inners: => course2_week1.generator.Generator[course2_week1.generator.Inner]

  def trees: Generator[Tree] = for {
    isLeaf <- booleans
    tree <- if (isLeaf) leafs else inners
  } yield tree                                    //> trees: => course2_week1.generator.Generator[course2_week1.generator.Tree]
	
	trees.generate                            //> res0: course2_week1.generator.Tree = Inner(Inner(Leaf(1197067613),Leaf(17970
                                                  //| 34307)),Inner(Leaf(636125739),Inner(Inner(Inner(Inner(Leaf(-1599221866),Leaf
                                                  //| (58614)),Leaf(-2079164818)),Leaf(-740129853)),Inner(Inner(Inner(Inner(Leaf(-
                                                  //| 1006068407),Leaf(-522387221)),Leaf(-941319401)),Leaf(1762940146)),Inner(Inne
                                                  //| r(Leaf(197972156),Inner(Leaf(-1825834690),Leaf(400832323))),Inner(Inner(Inne
                                                  //| r(Inner(Inner(Leaf(-134055966),Leaf(1042263194)),Leaf(-238383303)),Inner(Inn
                                                  //| er(Inner(Leaf(-815266478),Leaf(-1069855800)),Inner(Inner(Leaf(1438622864),In
                                                  //| ner(Inner(Leaf(-1551903962),Inner(Leaf(1543026734),Leaf(-582400752))),Leaf(-
                                                  //| 1261119619))),Leaf(1254100301))),Inner(Inner(Leaf(-1672219725),Leaf(-6538220
                                                  //| 9)),Inner(Leaf(-576469654),Leaf(-683692928))))),Inner(Leaf(-248618794),Leaf(
                                                  //| 197716237))),Leaf(-381543354)))))))
}