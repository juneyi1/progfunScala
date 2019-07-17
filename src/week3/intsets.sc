package week3

object intsets {
  val t1 = new NonEmpty(3, new Empty, new Empty)  //> t1  : week3.NonEmpty = {.3.}
  val e1 = new Empty                              //> e1  : week3.Empty = .
  val e2 = new Empty                              //> e2  : week3.Empty = .
  val t = e1.toString                             //> t  : String = .
  val t2 = t1 incl 4                              //> t2  : week3.IntSet = {.3{.4.}}
  val c = t2.contains(1)                          //> c  : Boolean = false
  val t3 = t1 incl 5                              //> t3  : week3.IntSet = {.3{.5.}}
  val t4 = t2 union t3                            //> t4  : week3.IntSet = {.3{{.4.}5.}}
  val e1e = e1.isEmpty                            //> e1e  : Boolean = true
  val t3e = t3.isEmpty                            //> t3e  : Boolean = false
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