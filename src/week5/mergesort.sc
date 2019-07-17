package week5
import math.Ordering

object mergesort {
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
  }                                               //> msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]
  
  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
  msort(nums)((x, y) => x < y)                    //> res0: List[Int] = List(-4, 1, 2, 5, 7)
  msort(fruits)((x, y) => x.compareTo(y) < 0)     //> res1: List[String] = List(apple, banana, orange, pineapple)
  
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
  }                                               //> msort1: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]
  
  msort1(nums)                                    //> res2: List[Int] = List(-4, 1, 2, 5, 7)
  msort1(fruits)                                  //> res3: List[String] = List(apple, banana, orange, pineapple)
  
}