public class Kette {
  Knoten kopf = new Knoten(null, null, "Kopf");
  Knoten ende = new Knoten(kopf, null, "Ende");
  public static void main(String[] args) {
    Kette kette = new Kette();
    kette.kopf.successor = kette.ende;
    kette.push("Hello");
    kette.push("World");
    kette.print();
    System.out.print(kette.kopf.successor.successor.data);
  }
  
  public Knoten pop() {
    if (kopf.successor != ende) {
      Knoten poppedKnoten = kopf.successor;
      
      kopf.successor = poppedKnoten.successor;
      kopf.successor.predecessor = kopf;
      
      System.out.println("Popped knoten");
      
      return poppedKnoten;
    } else {
      System.out.println("Error: Cant pop ende Knoten");
      return null;
    }
  }
  
  public void push(Object data) {
    Knoten knoten = new Knoten(kopf, kopf.successor, data);
    kopf.successor.predecessor = knoten;
    kopf.successor = knoten;
    
    System.out.println("Pushed knoten with value " + knoten.data);
  }
  
  public void print() {
    Knoten knoten = kopf;
    int index = 1;
    while (knoten != null) { 
      System.out.print(index + ": " + knoten.data + " ");
      index++;
      knoten = knoten.successor;
    }
    System.out.println();
  }
}
