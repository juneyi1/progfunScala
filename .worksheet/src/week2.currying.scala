package week2

object currying {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(205); 
	def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
		if (a > b) zero
		else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
	};System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(91); 
	def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""product2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(28); val res$0 = 
	product2(x => x * x)(3, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(115); 


  def product(f: Int => Int)(a: Int, b: Int): Int = {
  		if (a > b) 1
  		else f(a) * product(f)(a + 1, b)
  	};System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(27); val res$1 = 
	product(x => x * x)(3, 4);System.out.println("""res1: Int = """ + $show(res$1));$skip(43); 

	def fact(n: Int) = product(x => x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(9); val res$2 = 
	fact(4);System.out.println("""res2: Int = """ + $show(res$2))}
	
   
}
