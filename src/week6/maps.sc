package week6

object maps {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V 
                                                  //| -> 5, X -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)

  capitalOfCountry get "US"                       //> res0: Option[String] = Some(Washington)
  capitalOfCountry get "Tokyo"                    //> res1: Option[String] = None
}