package week5
import math.Ordering

object mergesort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(565); 
  //println("Welcome to the Scala worksheet")
  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) => {
          if (lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
        }
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  };System.out.println("""msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]""");$skip(37); 
  
  val nums = List(2, -4, 5, 7, 1);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(62); 
  val fruits = List("apple", "pineapple", "orange", "banana");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(31); val res$0 = 
  msort(nums)((x, y) => x < y);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(46); val res$1 = 
  msort(fruits)((x, y) => x.compareTo(y) < 0);System.out.println("""res1: List[String] = """ + $show(res$1));$skip(471); 
  
  def msort1[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) => {
          if (ord.lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
        }
      }

      val (fst, snd) = xs splitAt n
      merge(msort1(fst), msort1(snd))
    }
  };System.out.println("""msort1: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]""");$skip(18); val res$2 = 
  
  msort1(nums);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(17); val res$3 = 
  msort1(fruits);System.out.println("""res3: List[String] = """ + $show(res$3))}
  
}
