package week6

object pairs {
  //println("Welcome to the Scala worksheet")
  val xs = Array(1, 2, 3, 44)                     //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)

  val s = "Hello World"                           //> s  : String = Hello World
  s filter (c => c.isUpper)                       //> res1: String = HW

  val r: Range = 1 until 5                        //> r  : Range = Range 1 until 5
  val s1: Range = 1 to 5                          //> s1  : Range = Range 1 to 5
  val r1 = 1 to 10 by 3                           //> r1  : scala.collection.immutable.Range = Range 1 to 10 by 3
  val r2 = 6 to 1 by -2                           //> r2  : scala.collection.immutable.Range = inexact Range 6 to 1 by -2

  val pairs = List(1, 2, 3) zip s                 //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pairs.unzip                                     //> res2: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  s flatMap (c => List('.', c))                   //> res3: String = .H.e.l.l.o. .W.o.r.l.d

  xs.sum                                          //> res4: Int = 50
  xs.max                                          //> res5: Int = 44

  val p = List(1) zip s                           //> p  : List[(Int, Char)] = List((1,H))

  def isPrime(n: Int) = (2 until n) forall (n % _ != 0)
                                                  //> isPrime: (n: Int)Boolean
  val n = 7                                       //> n  : Int = 7

  (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j))) filter (pair =>
    isPrime(pair._1 + pair._2))                   //> res6: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  val st = (1 to 6).toSet                         //> st  : scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3, 4)
  st.nonEmpty                                     //> res7: Boolean = true
  5 / 2                                           //> res8: Int(2) = 2

  val l1 = List(('a', 2), ('b', 2))               //> l1  : List[(Char, Int)] = List((a,2), (b,2))

  def wordOccurrences(w: String): List[(Char, Int)] =
    { w.toLowerCase groupBy ((element: Char) => element) map { case (k, v) => (k, v.length) } }.toList sortWith (_._1 < _._1)
                                                  //> wordOccurrences: (w: String)List[(Char, Int)]

  /** Converts a sentence into its character occurrence list. */
  def sentenceOccurrences(s: List[String]): List[(Char, Int)] = wordOccurrences(s mkString "")
                                                  //> sentenceOccurrences: (s: List[String])List[(Char, Int)]

  def combinations(l: List[(Char, Int)]): List[List[(Char, Int)]] =
    if (l.isEmpty) List(List())
    else {
      for {
        n <- 0 to l.head._2
        rest <- combinations(l.tail)
      } yield {
        if (n == 0) rest else (l.head._1, n) :: rest
      }
    }.toList                                      //> combinations: (l: List[(Char, Int)])List[List[(Char, Int)]]

  def subtract(x: List[(Char, Int)], y: List[(Char, Int)]): List[(Char, Int)] = {
    def minusTerm(terms: List[(Char, Int)], term: (Char, Int)): List[(Char, Int)] = {
      val (lttr, freq) = term
      val map = terms.toMap
      (map + (lttr -> (map(lttr) - freq))).toList filter (x => (x._2 > 0))
    }
    (y foldLeft x)(minusTerm)
  }                                               //> subtract: (x: List[(Char, Int)], y: List[(Char, Int)])List[(Char, Int)]

  val l3 = List(('a', 1), ('b', 2), ('c', 3))     //> l3  : List[(Char, Int)] = List((a,1), (b,2), (c,3))
  val l4 = List(('a', 1))                         //> l4  : List[(Char, Int)] = List((a,1))
  val l5 = List(('b', 2))                         //> l5  : List[(Char, Int)] = List((b,2))

  subtract(l3, l4)                                //> res9: List[(Char, Int)] = List((b,2), (c,3))
  subtract(l3, l5)                                //> res10: List[(Char, Int)] = List((a,1), (c,3))
  combinations(l1)                                //> res11: List[List[(Char, Int)]] = List(List(), List((b,1)), List((b,2)), Lis
                                                  //| t((a,1)), List((a,1), (b,1)), List((a,1), (b,2)), List((a,2)), List((a,2), 
                                                  //| (b,1)), List((a,2), (b,2)))
  l1 take 1                                       //> res12: List[(Char, Int)] = List((a,2))
  l1.head                                         //> res13: (Char, Int) = (a,2)
  l1.tail                                         //> res14: List[(Char, Int)] = List((b,2))

  val sentence = List("Yes", "man")               //> sentence  : List[String] = List(Yes, man)

  val sOccurances = sentenceOccurrences(sentence) //> sOccurances  : List[(Char, Int)] = List((a,1), (e,1), (m,1), (n,1), (s,1), 
                                                  //| (y,1))
  val dictionary = List("en", "as", "my", "man", "yes", "men", "say", "sane", "Sean")
                                                  //> dictionary  : List[String] = List(en, as, my, man, yes, men, say, sane, Sea
                                                  //| n)
  val dictionaryByOccurrences: Map[List[(Char, Int)], List[String]] = dictionary groupBy wordOccurrences withDefaultValue List()
                                                  //> dictionaryByOccurrences  : Map[List[(Char, Int)],List[String]] = Map(List((
                                                  //| a,1), (s,1)) -> List(as), List((a,1), (m,1), (n,1)) -> List(man), List((a,1
                                                  //| ), (e,1), (n,1), (s,1)) -> List(sane, Sean), List((e,1), (m,1), (n,1)) -> L
                                                  //| ist(men), List((e,1), (n,1)) -> List(en), List((e,1), (s,1), (y,1)) -> List
                                                  //| (yes), List((m,1), (y,1)) -> List(my), List((a,1), (s,1), (y,1)) -> List(sa
                                                  //| y))

  combinations(sOccurances)                       //> res15: List[List[(Char, Int)]] = List(List(), List((y,1)), List((s,1)), Lis
                                                  //| t((s,1), (y,1)), List((n,1)), List((n,1), (y,1)), List((n,1), (s,1)), List(
                                                  //| (n,1), (s,1), (y,1)), List((m,1)), List((m,1), (y,1)), List((m,1), (s,1)), 
                                                  //| List((m,1), (s,1), (y,1)), List((m,1), (n,1)), List((m,1), (n,1), (y,1)), L
                                                  //| ist((m,1), (n,1), (s,1)), List((m,1), (n,1), (s,1), (y,1)), List((e,1)), Li
                                                  //| st((e,1), (y,1)), List((e,1), (s,1)), List((e,1), (s,1), (y,1)), List((e,1)
                                                  //| , (n,1)), List((e,1), (n,1), (y,1)), List((e,1), (n,1), (s,1)), List((e,1),
                                                  //|  (n,1), (s,1), (y,1)), List((e,1), (m,1)), List((e,1), (m,1), (y,1)), List(
                                                  //| (e,1), (m,1), (s,1)), List((e,1), (m,1), (s,1), (y,1)), List((e,1), (m,1), 
                                                  //| (n,1)), List((e,1), (m,1), (n,1), (y,1)), List((e,1), (m,1), (n,1), (s,1)),
                                                  //|  List((e,1), (m,1), (n,1), (s,1), (y,1)), List((a,1)), List((a,1), (y,1)), 
                                                  //| List((a,1), (s,1)), List((a,1), (s,1), (y,1)), List((a,1), (n,1)), List((a,
                                                  //| 1), (n,1), (y,1)), List
                                                  //| Output exceeds cutoff limit.

  def sentenceAnagrams(sentence: List[String]): List[List[String]] = {
    val sntncOccr = sentenceOccurrences(sentence)

    def rec(occ: List[(Char, Int)]): List[List[String]] = {
      if (occ.isEmpty) List(List())
      else {
        for {
          combination <- combinations(occ)
          word <- dictionaryByOccurrences(combination)
          rest <- rec(subtract(occ, combination))
        } yield {
          //word :: rest
          List(word)
        }
      }
    }
    rec(sntncOccr)
  }                                               //> sentenceAnagrams: (sentence: List[String])List[List[String]]

  val sentence1 = List("Yes", "man")              //> sentence1  : List[String] = List(Yes, man)

  sentenceAnagrams(sentence1)                     //> res16: List[List[String]] = List(List(man))

  for {
    combination <- combinations(sOccurances)
    word <- dictionaryByOccurrences(combination)
  } yield List(word)                              //> res17: List[List[String]] = List(List(my), List(yes), List(en), List(men), 
                                                  //| List(as), List(say), List(man), List(sane), List(Sean))

  //for {
  // 	combination <- combinations(sOccurances)
  //  	word <- dictionaryByOccurrences(combination)
  //} yield subtract(sOccurances, combination)
  //  for {
  //          combination <- combinations(o)
  //  word <- dictionaryByOccurrences(combination)
  //rest <- recurrsv(subtract(o, combination))
  //        } yield List('yes')

}