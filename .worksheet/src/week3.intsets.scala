package week3

object intsets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
  val t1 = new NonEmpty(3, new Empty, new Empty);System.out.println("""t1  : week3.NonEmpty = """ + $show(t1 ));$skip(21); 
  val e1 = new Empty;System.out.println("""e1  : week3.Empty = """ + $show(e1 ));$skip(21); 
  val e2 = new Empty;System.out.println("""e2  : week3.Empty = """ + $show(e2 ));$skip(22); 
  val t = e1.toString;System.out.println("""t  : String = """ + $show(t ));$skip(21); 
  val t2 = t1 incl 4;System.out.println("""t2  : week3.IntSet = """ + $show(t2 ));$skip(25); 
  val c = t2.contains(1);System.out.println("""c  : Boolean = """ + $show(c ));$skip(21); 
  val t3 = t1 incl 5;System.out.println("""t3  : week3.IntSet = """ + $show(t3 ));$skip(23); 
  val t4 = t2 union t3;System.out.println("""t4  : week3.IntSet = """ + $show(t4 ));$skip(23); 
  val e1e = e1.isEmpty;System.out.println("""e1e  : Boolean = """ + $show(e1e ));$skip(23); 
  val t3e = t3.isEmpty;System.out.println("""t3e  : Boolean = """ + $show(t3e ))}
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
  def isEmpty: Boolean
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet): IntSet = other
  def isEmpty = true
  override def toString = "."
}

//object Empty extends IntSet {
//  def contains(x: Int): Boolean = false
//  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
//  override def toString = "."
//}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  
  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  
  def union(other: IntSet): IntSet =
  		right union (left union (other incl elem))
   	//((left union right) union other) incl elem
  
  def isEmpty = false
  override def toString = "{" + left + elem + right + "}"
}
