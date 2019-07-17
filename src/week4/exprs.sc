package week4

object exprs {
	def eval(e: Expr): Int = e match {
    case Number(n)   => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
    case Var(e) => throw new Error("No value for variable" + e)
    case Prod(e1, e2) => eval(e1) * eval(e2)
	}                                         //> eval: (e: week4.Expr)Int

  def show(e: Expr): String = e match {
    case Number(n)   => n.toString
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Var(x) => x
    case Prod(Sum(e1, e2), Sum(e3, e4)) => "(" + show(e1) + " + " + show(e2) + ")" + " * " + "(" + show(e3) + " + " + show(e4) + ")"
    case Prod(e1, Sum(e2, e3)) => show(e1) + " * " + "(" + show(e2) + " + " + show(e3) + ")"
    case Prod(Sum(e1, e2), e3) => "(" + show(e1) + " + " + show(e2) + ")" + " * " + show(e3)
    case Prod(e1, e2) => show(e1) + " * " + show(e2)
  }                                               //> show: (e: week4.Expr)String
  //println("Welcome to the Scala worksheet")
  show(Number(1))                                 //> res0: String = 1
  show(Sum(Number(2), Number(6)))                 //> res1: String = 2 + 6
  show(Sum(Prod(Number(2), Var("x")), Var("y")))  //> res2: String = 2 * x + y
  show(Prod(Sum(Var("2"  ), Var("x")), Var("y"))) //> res3: String = (2 + x) * y
  show(Prod(Var("y"), Sum(Number(2), Var("x"))))  //> res4: String = y * (2 + x)
  show(Prod(Sum(Number(2), Var("x")), Sum(Number(3), Var("y"))))
                                                  //> res5: String = (2 + x) * (3 + y)
}