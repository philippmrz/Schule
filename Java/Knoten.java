public class Knoten {
  Knoten predecessor;
  Knoten successor;
  Object data;
  
  public Knoten(Knoten predecessor, Knoten successor, Object data) {
    this.predecessor = predecessor;
    this.successor = successor;
    this.data = data;
  }
}
