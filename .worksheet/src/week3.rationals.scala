package week3

object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  val x = new Rational(1, 3);System.out.println("""x  : week3.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : week3.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : week3.Rational = """ + $show(z ));$skip(10); val res$0 = 
  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(8); val res$2 = 
  x + y;System.out.println("""res2: week3.Rational = """ + $show(res$2));$skip(5); val res$3 = 
  -x;System.out.println("""res3: week3.Rational = """ + $show(res$3));$skip(12); val res$4 = 
  x - y - z;System.out.println("""res4: week3.Rational = """ + $show(res$4));$skip(8); val res$5 = 
  y + y;System.out.println("""res5: week3.Rational = """ + $show(res$5));$skip(8); val res$6 = 
  x < y;System.out.println("""res6: Boolean = """ + $show(res$6));$skip(10); val res$7 = 
  x max y;System.out.println("""res7: week3.Rational = """ + $show(res$7));$skip(51); val res$8 = 
  //val exp = new Rational(2, 0)
  new Rational(2);System.out.println("""res8: week3.Rational = """ + $show(res$8))}
}

class Rational(x: Int, y: Int) {
	require(y != 0, "denominator must not be zero")
	
	def this(x: Int) = this(x, 1)
	
	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a%b)
	private val g = gcd(x, y)
	
	def numer = x/g
	def denom = y/g
	
	def < (that: Rational) = numer*that.denom < denom*that.numer
	
	def max(that: Rational) = if (this < that) that else this
	
	def + (that: Rational) = {
		new Rational(
			numer*that.denom + denom*that.numer,
			denom*that.denom)
	}
	
	def unary_- : Rational = new Rational(-numer, denom)

	def - (that: Rational) = this + -that

	override def toString = {
		numer + "/" + denom
		//val g = gcd(x, y)
		//numer/g + "/" + denom/g
	}
}
