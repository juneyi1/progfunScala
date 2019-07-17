package week7

object books {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet")

  case class Book(title: String, authors: List[String]);$skip(735); 

  val books: List[Book] = List(
    Book(
      title = "Structure and Interpretation of Computer Programs",
      authors = List("Abelson, Harald", "Sussman, Gerald J.")),
    Book(
      title = "Introduction to Functional Programming",
      authors = List("Bird, Richard", "Wadler, Phil")),
    Book(
      title = "Effective Java",
      authors = List("Bloch, Joshua")),
    Book(
      title = "Fake Java Book",
      authors = List("Bloch, Joshua")),
    Book(
      title = "Java Puzzlers",
      authors = List("Bloch, Joshua", "Gafter, Neal")),
    Book(
      title = "Programming in Scala",
      authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")));System.out.println("""books  : List[week7.books.Book] = """ + $show(books ));$skip(88); val res$0 = 
  for {
    b <- books
    a <- b.authors
    if a startsWith "Bird,"
  } yield b.title;System.out.println("""res0: List[String] = """ + $show(res$0));$skip(96); val res$1 = 

  books flatMap (b =>
    (b.authors).withFilter(a => a startsWith "Bird,").map(a => b.title));System.out.println("""res1: List[String] = """ + $show(res$1));$skip(82); val res$2 = 

  for {
    b <- books
    if (b.title indexOf "Program") >= 0
  } yield b.title;System.out.println("""res2: List[String] = """ + $show(res$2));$skip(29); 

  val bookSet = books.toSet;System.out.println("""bookSet  : scala.collection.immutable.Set[week7.books.Book] = """ + $show(bookSet ));$skip(166); 
  val three_book_author = for {
    b1 <- bookSet
    b2 <- bookSet
    if b1.title < b2.title
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield a1;System.out.println("""three_book_author  : scala.collection.immutable.Set[String] = """ + $show(three_book_author ));$skip(27); val res$3 = 

  three_book_author.toSet;System.out.println("""res3: scala.collection.immutable.Set[String] = """ + $show(res$3))}
}
