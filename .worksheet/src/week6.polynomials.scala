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
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(802); 

  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2));System.out.println("""p1  : week6.polynomials.Poly = """ + $show(p1 ));$skip(45); 
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0));System.out.println("""p2  : week6.polynomials.Poly = """ + $show(p2 ));$skip(50); 
  val p3 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2);System.out.println("""p3  : week6.polynomials.Poly = """ + $show(p3 ));$skip(11); val res$0 = 

  p1 + p2;System.out.println("""res0: week6.polynomials.Poly = """ + $show(res$0));$skip(14); val res$1 = 
  p1.terms(5);System.out.println("""res1: Double = """ + $show(res$1));$skip(69); 
  
  val m1 = Map(1 -> 2.0, 2 -> 3.0, 3 -> 4.0) withDefaultValue 0.0;System.out.println("""m1  : scala.collection.immutable.Map[Int,Double] = """ + $show(m1 ));$skip(26); 
  val m2 = m1 + (5-> 6.0);System.out.println("""m2  : scala.collection.immutable.Map[Int,Double] = """ + $show(m2 ));$skip(35); 
  val m3 = m1 + (5-> 6.0, 6-> 7.0);System.out.println("""m3  : scala.collection.immutable.Map[Int,Double] = """ + $show(m3 ));$skip(35); 
  val m4 = m2 + (5-> 5.0, 6-> 7.0);System.out.println("""m4  : scala.collection.immutable.Map[Int,Double] = """ + $show(m4 ))}
}
