package week6

import scala.io.Source

object mnemonics {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(360); 
  //val in = Source.fromURL("https://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")
  // https://www.coursera.org/learn/progfun1/discussions/weeks/6/threads/bm29O81CEeaOOwpinTYl8A
  val in = Source.fromURL("https://lamp.epfl.ch/wp-content/uploads/2019/01/linuxwords.txt");System.out.println("""in  : scala.io.BufferedSource = """ + $show(in ));$skip(84); 
  val words = in.getLines.toList filter (word => word forall (chr => chr.isLetter));System.out.println("""words  : List[String] = """ + $show(words ));$skip(251); 

//http://lamp.epfl.ch/wp-content/uploads/2019/01/linuxwords.txt
  //println("Welcome to the Scala worksheet")
  val mnem = Map(
    '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
    '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ");System.out.println("""mnem  : scala.collection.immutable.Map[Char,String] = """ + $show(mnem ));$skip(211); 
  /** Invert the mnem map to give a map from chars	'A' ...'Z' to '2' ... '9'  **/
  val charCode: Map[Char, Char] =
    for {
      (number, letters) <- mnem
      letter <- letters
    } yield letter -> number;System.out.println("""charCode  : Map[Char,Char] = """ + $show(charCode ));$skip(161); 

  /** Maps a word to the digit string it can represent, e.g. "Java" -> "5282" */
  def wordCode(word: String): String = {
    word.toUpperCase map charCode
  };System.out.println("""wordCode: (word: String)String""");$skip(19); val res$0 = 

	wordCode("Java");System.out.println("""res0: String = """ + $show(res$0));$skip(299); 
	
	/**
	 * A map from digit strings to the words that represent them,
	 * e.g. "5282" -> List("Java", "Kata", "Lava", ...)
	 * Nonte: A missing number should map to the empty set, e.g., "1111" -> List()
	 */
	val wordsForNum: Map[String, Seq[String]] = words groupBy wordCode withDefaultValue Seq();System.out.println("""wordsForNum  : Map[String,Seq[String]] = """ + $show(wordsForNum ));$skip(331); 
  
  /** Return all ways to encode a number as a list of words */
  def encode(number: String): Set[List[String]] =
  		if (number.isEmpty) Set(List())
  		else {
  			for {
  				split <- 1 to number.length
  				word <- wordsForNum(number take split)
  				rest <- encode(number drop split)
  			} yield word :: rest
  		}.toSet;System.out.println("""encode: (number: String)Set[List[String]]""");$skip(29); val res$1 = 
  		
  	encode("7225247368");System.out.println("""res1: Set[List[String]] = """ + $show(res$1));$skip(88); 
  def translate(number: String): Set[String] =
  			encode(number) map (_ mkString " ");System.out.println("""translate: (number: String)Set[String]""");$skip(25); val res$2 = 
	translate("7225247368");System.out.println("""res2: Set[String] = """ + $show(res$2))}
  
  		 
}
