package week4

object exprs {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(247); 
	def eval(e: Expr): Int = e match {
    case Number(n)   => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
    case Var(e) => throw new Error("No value for variable" + e)
    case Prod(e1, e2) => eval(e1) * eval(e2)
	};System.out.println("""eval: (e: week4.Expr)Int""");$skip(525); 

  def show(e: Expr): String = e match {
    case Number(n)   => n.toString
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Var(x) => x
    case Prod(Sum(e1, e2), Sum(e3, e4)) => "(" + show(e1) + " + " + show(e2) + ")" + " * " + "(" + show(e3) + " + " + show(e4) + ")"
    case Prod(e1, Sum(e2, e3)) => show(e1) + " * " + "(" + show(e2) + " + " + show(e3) + ")"
    case Prod(Sum(e1, e2), e3) => "(" + show(e1) + " + " + show(e2) + ")" + " * " + show(e3)
    case Prod(e1, e2) => show(e1) + " * " + show(e2)
  };System.out.println("""show: (e: week4.Expr)String""");$skip(64); val res$0 = 
  //println("Welcome to the Scala worksheet")
  show(Number(1));System.out.println("""res0: String = """ + $show(res$0));$skip(34); val res$1 = 
  show(Sum(Number(2), Number(6)));System.out.println("""res1: String = """ + $show(res$1));$skip(49); val res$2 = 
  show(Sum(Prod(Number(2), Var("x")), Var("y")));System.out.println("""res2: String = """ + $show(res$2));$skip(50); val res$3 = 
  show(Prod(Sum(Var("2"  ), Var("x")), Var("y")));System.out.println("""res3: String = """ + $show(res$3));$skip(49); val res$4 = 
  show(Prod(Var("y"), Sum(Number(2), Var("x"))));System.out.println("""res4: String = """ + $show(res$4));$skip(65); val res$5 = 
  show(Prod(Sum(Number(2), Var("x")), Sum(Number(3), Var("y"))));System.out.println("""res5: String = """ + $show(res$5))}
}
