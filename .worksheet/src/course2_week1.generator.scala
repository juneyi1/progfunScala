package course2_week1

object generator {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(85); 
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
  };$skip(388); 

  val integers = new Generator[Int] {
    def generate = scala.util.Random.nextInt()
  };System.out.println("""integers  : course2_week1.generator.Generator[Int] = """ + $show(integers ));$skip(44); 

  val booleans = integers map (x => x > 0)

  trait Tree

  case class Inner(left: Tree, right: Tree) extends Tree

  case class Leaf(x: Int) extends Tree;System.out.println("""booleans  : course2_week1.generator.Generator[Boolean] = """ + $show(booleans ));$skip(186); 

  def leafs: Generator[Leaf] = for {
    x <- integers
  } yield Leaf(x);System.out.println("""leafs: => course2_week1.generator.Generator[course2_week1.generator.Leaf]""");$skip(92); 

  def inners: Generator[Inner] = for {
    l <- trees
    r <- trees
  } yield Inner(l, r);System.out.println("""inners: => course2_week1.generator.Generator[course2_week1.generator.Inner]""");$skip(118); 

  def trees: Generator[Tree] = for {
    isLeaf <- booleans
    tree <- if (isLeaf) leafs else inners
  } yield tree;System.out.println("""trees: => course2_week1.generator.Generator[course2_week1.generator.Tree]""");$skip(18); val res$0 = 
	
	trees.generate;System.out.println("""res0: course2_week1.generator.Tree = """ + $show(res$0))}
}
