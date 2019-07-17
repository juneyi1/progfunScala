package week5

object listfunc {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(112); 
  //println("Welcome to the Scala worksheet")
  val nums = List(2, -4, 5, 7, 1);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(62); 
  val fruits = List("apple", "pineapple", "orange", "banana");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(53); 
  val data = List("a", "a", "a", "b", "c", "c", "a");System.out.println("""data  : List[String] = """ + $show(data ));$skip(27); val res$0 = 
  nums filter (x => x > 0);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(30); val res$1 = 
  nums filterNot (x => x > 0);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(30); val res$2 = 
  nums partition (x => x > 0);System.out.println("""res2: (List[Int], List[Int]) = """ + $show(res$2));$skip(31); val res$3 = 

  nums takeWhile (x => x > 0);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(30); val res$4 = 
  nums dropWhile (x => x > 0);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(25); val res$5 = 
  nums span (x => x > 0);System.out.println("""res5: (List[Int], List[Int]) = """ + $show(res$5));$skip(262); 

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 => {
      List(xs takeWhile (y => (y == x))) ++ pack(xs dropWhile (y => (y == x)))
//      val (fst, snd) = xs span (y => (y == x))
//      fst :: pack(snd)
    }
  };System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(13); val res$6 = 
  pack(data);System.out.println("""res6: List[List[String]] = """ + $show(res$6));$skip(137); 
                                                  
  def encode[T](xs: List[T]): List[(T, Int)] = pack(xs) map (x => (x.head, x.length));System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""")}
}
