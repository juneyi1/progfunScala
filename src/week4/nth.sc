import week4._

object nth {
  def nth[T](n: Int, xs: List[T]): T = {
   	if (xs.isEmpty) throw new IndexOutOfBoundsException
  		else if (n == 0) xs.head
  		else nth(n-1, xs.tail)
  }                                               //> nth: [T](n: Int, xs: week4.List[T])T
  
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : week4.Cons[Int] = week4.Cons@e580929
  
  nth(2, list)                                    //> res0: Int = 3
  nth(-1, list)                                   //> java.lang.IndexOutOfBoundsException
                                                  //| 	at nth$.nth$1(nth.scala:5)
                                                  //| 	at nth$.$anonfun$main$1(nth.scala:13)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$anonfun$$ex
                                                  //| ecute$1(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:76)
                                                  //| 	at nth$.main(nth.scala:3)
                                                  //| 	at nth.main(nth.scala)
// nth(4, list)
}