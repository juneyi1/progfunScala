package week6

object polynomials {

  class Poly(terms0: Map[Int, Double]) {
    def this(bindings: (Int, Double)*) = this(bindings.toMap)
    val terms = terms0 withDefaultValue 0.0
    //def +(other: Poly) = new Poly(terms ++ (other.terms map adjust))
    def +(other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      exp -> (coeff + terms(exp))
    }
    def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
      val (exp, coeff) = term
      terms + (exp -> (coeff + terms(exp)))
    }
    override def toString =
      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
  }

  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
                                                  //> p1  : week6.polynomials.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))      //> p2  : week6.polynomials.Poly = 7.0x^3 + 3.0x^0
  val p3 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2) //> p3  : week6.polynomials.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1

  p1 + p2                                         //> res0: week6.polynomials.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0
  p1.terms(5)                                     //> res1: Double = 6.2
  
  val m1 = Map(1 -> 2.0, 2 -> 3.0, 3 -> 4.0) withDefaultValue 0.0
                                                  //> m1  : scala.collection.immutable.Map[Int,Double] = Map(1 -> 2.0, 2 -> 3.0, 3
                                                  //|  -> 4.0)
  val m2 = m1 + (5-> 6.0)                         //> m2  : scala.collection.immutable.Map[Int,Double] = Map(1 -> 2.0, 2 -> 3.0, 
                                                  //| 3 -> 4.0, 5 -> 6.0)
  val m3 = m1 + (5-> 6.0, 6-> 7.0)                //> m3  : scala.collection.immutable.Map[Int,Double] = Map(5 -> 6.0, 1 -> 2.0, 
                                                  //| 6 -> 7.0, 2 -> 3.0, 3 -> 4.0)
  val m4 = m2 + (5-> 5.0, 6-> 7.0)                //> m4  : scala.collection.immutable.Map[Int,Double] = Map(5 -> 5.0, 1 -> 2.0, 
                                                  //| 6 -> 7.0, 2 -> 3.0, 3 -> 4.0)
}