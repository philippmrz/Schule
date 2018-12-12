import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kette {
  Knoten kopf = new Knoten(null, null, "Kopf");
  Knoten ende = new Knoten(kopf, null, "Ende");
  public static void main(String[] args) {
    Kette kette = initialize();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int option = 1;
    while (true) {
      printOptions(); 
      try {
        option = Integer.parseInt(br.readLine());
      } catch (IOException e) {
        System.err.println("Invalid Format!");
      }
      switch (option) {
        case  1: 
          kette.print();
          break;
        case  2: 
          kette.pop();
          break;
        case 3:
          kette.pushCLI(br, kette);
          break;
        default: 
          System.out.println("Invalid input");
      }
    }
    
  }

  public Knoten pop() {
    if (kopf.successor != ende) {
      Knoten poppedKnoten = kopf.successor;
      
      kopf.successor = poppedKnoten.successor;
      kopf.successor.predecessor = kopf;
      
      System.out.println("Popped knoten with value " + poppedKnoten.data);
      
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
  
  void pushCLI(BufferedReader br, Kette kette) {
    System.out.println("Enter the data of the element you want to push:");
    String data = "";
    try {
      data = br.readLine();
    } catch (IOException e) {
      System.out.println("Invalid input");
    }
    
    kette.push(data);
  }
  
  static Kette initialize() {
    Kette kette = new Kette();
    kette.kopf.successor = kette.ende;
    return kette;
  }
  
  static void printOptions() {
    System.out.println("Press [1] to print current chain");
    System.out.println("Press [2] to pop element");
    System.out.println("Press [3] to push element"); 
  }
}
