package week7

class Pouring(capacity: Vector[Int]) { // capacity for each glass

// States (type alias)
  type State = Vector[Int]
  val initialState = capacity map (x => 0)
  
// Moves
  trait Move {
    def change(state: State): State
  }
  case class Empty(glass: Int) extends Move {
    def change(state: State) = state updated (glass, 0) // a new state object is generated by "updated" method
  }
  case class Fill(glass: Int) extends Move {
    def change(state: State) = state updated (glass, capacity(glass)) // a new state object is generated by "updated" method
  }
  case class Pour(from: Int, to: Int) extends Move {
    def change(state: State) = {
      val amount = state(from) min (capacity(to) - state(to))
      state updated (from, state(from) - amount) updated (to, state(to) + amount) // a new state object is generated by "updated" method 
    }        
  }
  
  val glasses = 0 until capacity.length
  
  val moves = {
    (for (g <- glasses) yield Empty(g)) ++
    (for (g <- glasses) yield Fill(g)) ++
    (for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))
  }
  
// Paths
  class Path(history: List[Move]) { //last move comes first in history
    def endState: State = trackState(history)
    
  } 
  
}