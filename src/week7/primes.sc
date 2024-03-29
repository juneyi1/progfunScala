package week7

object primes {
  def from(n: Int): Stream[Int] = n #:: from(n+1) //> from: (n: Int)Stream[Int]
  
  val nats = from(0)                              //> nats  : Stream[Int] = Stream(0, ?)
 	val m4s = nats map (_ * 4)                //> m4s  : scala.collection.immutable.Stream[Int] = Stream(0, ?)
 	
 	(m4s take 100).toList                     //> res0: List[Int] = List(0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 
                                                  //| 56, 60, 64, 68, 72, 76, 80, 84, 88, 92, 96, 100, 104, 108, 112, 116, 120, 12
                                                  //| 4, 128, 132, 136, 140, 144, 148, 152, 156, 160, 164, 168, 172, 176, 180, 184
                                                  //| , 188, 192, 196, 200, 204, 208, 212, 216, 220, 224, 228, 232, 236, 240, 244,
                                                  //|  248, 252, 256, 260, 264, 268, 272, 276, 280, 284, 288, 292, 296, 300, 304, 
                                                  //| 308, 312, 316, 320, 324, 328, 332, 336, 340, 344, 348, 352, 356, 360, 364, 3
                                                  //| 68, 372, 376, 380, 384, 388, 392, 396)
  def sieve(s: Stream[Int]): Stream[Int] = {
  		s.head #:: sieve(s.tail filter (_ % s.head != 0))
  }                                               //> sieve: (s: Stream[Int])Stream[Int]
 
 	val primes = sieve(from(2))               //> primes  : Stream[Int] = Stream(2, ?)
 	
 	primes.take(100).toList                   //> res1: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 4
                                                  //| 7, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131
                                                  //| , 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211,
                                                  //|  223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 
                                                  //| 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 3
                                                  //| 97, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 48
                                                  //| 7, 491, 499, 503, 509, 521, 523, 541)
                                                  
  def sqrtStream(x: Double): Stream[Double] = {
  		def improve(guess: Double) = (guess + x / guess) / 2
  		lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
		guesses
  }                                               //> sqrtStream: (x: Double)Stream[Double]
  
  sqrtStream(4).take(10).toList                   //> res2: List[Double] = List(1.0, 2.5, 2.05, 2.000609756097561, 2.0000000929222
                                                  //| 947, 2.000000000000002, 2.0, 2.0, 2.0, 2.0)
  
  def isGoodEnough(guess: Double, x: Double) = {
  		math.abs((guess * guess - x) /x) < 0.0001
  }                                               //> isGoodEnough: (guess: Double, x: Double)Boolean
                                                  
	sqrtStream(4).filter(isGoodEnough(_, 4)).take(10).toList
                                                  //> res3: List[Double] = List(2.0000000929222947, 2.000000000000002, 2.0, 2.0, 2
                                                  //| .0, 2.0, 2.0, 2.0, 2.0, 2.0)
                                                  
  val til = 0 until 7                             //> til  : scala.collection.immutable.Range = Range 0 until 7
  
  for (i <- til) yield i                          //> res4: scala.collection.immutable.IndexedSeq[Int] = Vector(0, 1, 2, 3, 4, 5, 
                                                  //| 6)
}