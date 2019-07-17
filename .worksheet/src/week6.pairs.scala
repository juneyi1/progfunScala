package week6

object pairs {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(105); 
  //println("Welcome to the Scala worksheet")
  val xs = Array(1, 2, 3, 44);System.out.println("""xs  : Array[Int] = """ + $show(xs ));$skip(22); val res$0 = 
  xs map (x => x * 2);System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(25); 

  val s = "Hello World";System.out.println("""s  : String = """ + $show(s ));$skip(28); val res$1 = 
  s filter (c => c.isUpper);System.out.println("""res1: String = """ + $show(res$1));$skip(28); 

  val r: Range = 1 until 5;System.out.println("""r  : Range = """ + $show(r ));$skip(25); 
  val s1: Range = 1 to 5;System.out.println("""s1  : Range = """ + $show(s1 ));$skip(24); 
  val r1 = 1 to 10 by 3;System.out.println("""r1  : scala.collection.immutable.Range = """ + $show(r1 ));$skip(24); 
  val r2 = 6 to 1 by -2;System.out.println("""r2  : scala.collection.immutable.Range = """ + $show(r2 ));$skip(35); 

  val pairs = List(1, 2, 3) zip s;System.out.println("""pairs  : List[(Int, Char)] = """ + $show(pairs ));$skip(14); val res$2 = 
  pairs.unzip;System.out.println("""res2: (List[Int], List[Char]) = """ + $show(res$2));$skip(32); val res$3 = 
  s flatMap (c => List('.', c));System.out.println("""res3: String = """ + $show(res$3));$skip(10); val res$4 = 

  xs.sum;System.out.println("""res4: Int = """ + $show(res$4));$skip(9); val res$5 = 
  xs.max;System.out.println("""res5: Int = """ + $show(res$5));$skip(25); 

  val p = List(1) zip s;System.out.println("""p  : List[(Int, Char)] = """ + $show(p ));$skip(57); 

  def isPrime(n: Int) = (2 until n) forall (n % _ != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(12); 
  val n = 7;System.out.println("""n  : Int = """ + $show(n ));$skip(112); val res$6 = 

  (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j))) filter (pair =>
    isPrime(pair._1 + pair._2));System.out.println("""res6: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$6));$skip(26); 
  val st = (1 to 6).toSet;System.out.println("""st  : scala.collection.immutable.Set[Int] = """ + $show(st ));$skip(14); val res$7 = 
  st.nonEmpty;System.out.println("""res7: Boolean = """ + $show(res$7));$skip(8); val res$8 = 
  5 / 2;System.out.println("""res8: Int(2) = """ + $show(res$8));$skip(37); 

  val l1 = List(('a', 2), ('b', 2));System.out.println("""l1  : List[(Char, Int)] = """ + $show(l1 ));$skip(181); 

  def wordOccurrences(w: String): List[(Char, Int)] =
    { w.toLowerCase groupBy ((element: Char) => element) map { case (k, v) => (k, v.length) } }.toList sortWith (_._1 < _._1);System.out.println("""wordOccurrences: (w: String)List[(Char, Int)]""");$skip(161); 

  /** Converts a sentence into its character occurrence list. */
  def sentenceOccurrences(s: List[String]): List[(Char, Int)] = wordOccurrences(s mkString "");System.out.println("""sentenceOccurrences: (s: List[String])List[(Char, Int)]""");$skip(279); 

  def combinations(l: List[(Char, Int)]): List[List[(Char, Int)]] =
    if (l.isEmpty) List(List())
    else {
      for {
        n <- 0 to l.head._2
        rest <- combinations(l.tail)
      } yield {
        if (n == 0) rest else (l.head._1, n) :: rest
      }
    }.toList;System.out.println("""combinations: (l: List[(Char, Int)])List[List[(Char, Int)]]""");$skip(342); 

  def subtract(x: List[(Char, Int)], y: List[(Char, Int)]): List[(Char, Int)] = {
    def minusTerm(terms: List[(Char, Int)], term: (Char, Int)): List[(Char, Int)] = {
      val (lttr, freq) = term
      val map = terms.toMap
      (map + (lttr -> (map(lttr) - freq))).toList filter (x => (x._2 > 0))
    }
    (y foldLeft x)(minusTerm)
  };System.out.println("""subtract: (x: List[(Char, Int)], y: List[(Char, Int)])List[(Char, Int)]""");$skip(47); 

  val l3 = List(('a', 1), ('b', 2), ('c', 3));System.out.println("""l3  : List[(Char, Int)] = """ + $show(l3 ));$skip(26); 
  val l4 = List(('a', 1));System.out.println("""l4  : List[(Char, Int)] = """ + $show(l4 ));$skip(26); 
  val l5 = List(('b', 2));System.out.println("""l5  : List[(Char, Int)] = """ + $show(l5 ));$skip(20); val res$9 = 

  subtract(l3, l4);System.out.println("""res9: List[(Char, Int)] = """ + $show(res$9));$skip(19); val res$10 = 
  subtract(l3, l5);System.out.println("""res10: List[(Char, Int)] = """ + $show(res$10));$skip(19); val res$11 = 
  combinations(l1);System.out.println("""res11: List[List[(Char, Int)]] = """ + $show(res$11));$skip(12); val res$12 = 
  l1 take 1;System.out.println("""res12: List[(Char, Int)] = """ + $show(res$12));$skip(10); val res$13 = 
  l1.head;System.out.println("""res13: (Char, Int) = """ + $show(res$13));$skip(10); val res$14 = 
  l1.tail;System.out.println("""res14: List[(Char, Int)] = """ + $show(res$14));$skip(37); 

  val sentence = List("Yes", "man");System.out.println("""sentence  : List[String] = """ + $show(sentence ));$skip(51); 

  val sOccurances = sentenceOccurrences(sentence);System.out.println("""sOccurances  : List[(Char, Int)] = """ + $show(sOccurances ));$skip(86); 
  val dictionary = List("en", "as", "my", "man", "yes", "men", "say", "sane", "Sean");System.out.println("""dictionary  : List[String] = """ + $show(dictionary ));$skip(129); 
  val dictionaryByOccurrences: Map[List[(Char, Int)], List[String]] = dictionary groupBy wordOccurrences withDefaultValue List();System.out.println("""dictionaryByOccurrences  : Map[List[(Char, Int)],List[String]] = """ + $show(dictionaryByOccurrences ));$skip(29); val res$15 = 

  combinations(sOccurances);System.out.println("""res15: List[List[(Char, Int)]] = """ + $show(res$15));$skip(505); 

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
  };System.out.println("""sentenceAnagrams: (sentence: List[String])List[List[String]]""");$skip(38); 

  val sentence1 = List("Yes", "man");System.out.println("""sentence1  : List[String] = """ + $show(sentence1 ));$skip(31); val res$16 = 

  sentenceAnagrams(sentence1);System.out.println("""res16: List[List[String]] = """ + $show(res$16));$skip(124); val res$17 = 

  for {
    combination <- combinations(sOccurances)
    word <- dictionaryByOccurrences(combination)
  } yield List(word);System.out.println("""res17: List[List[String]] = """ + $show(res$17))}

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
