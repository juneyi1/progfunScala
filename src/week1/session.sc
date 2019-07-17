package week1

object session {
  1+3                                             //> res0: Int(4) = 4
  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def improve(guess: Double) =
      (guess + x / guess) / 2

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x)/x < 0.001

    sqrtIter(1.0)
  }                                               //> sqrt: (x: Double)Double
  sqrt(0.001)                                     //> res1: Double = 0.03162278245070105
  sqrt(0.1e-20)                                   //> res2: Double = 3.1633394544890125E-11
  sqrt(1.0e20)                                    //> res3: Double = 1.0000021484861237E10
  sqrt(1.0e50)                                    //> res4: Double = 1.0000003807575104E25
  
  def dbl(x: Double) = if (x == 0) x else x+10    //> dbl: (x: Double)Double
  abs(-5.0)                                       //> res5: Double = 5.0
  dbl(5.0)                                        //> res6: Double = 15.0
}