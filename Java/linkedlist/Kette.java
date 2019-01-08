package linkedlist;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kette {
  Knoten kopf = new Knoten(null, null, "Kopf");
  Knoten ende = new Knoten(kopf, null, "Ende");

  public static void main(String[] args) {
    Kette kette = initialize();

    kette.runCLI(kette);
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

  private void runCLI(Kette kette) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String option = "";
    boolean cont = true;
    while (cont) {
      printOptions();
      try {
        option = br.readLine();
      } catch (IOException e) {
        System.err.println("Invalid Format!");
      }
      switch (option) {
      case  "1":
        kette.print();
        break;
      case  "2":
        kette.pop();
        break;
      case "3":
        kette.pushCLI(br, kette);
        break;
      case "4":
        cont = false;
        break;
      case "":
        System.out.println("Enter something");
        break;
      default:
        System.out.println("Invalid input");
      }
    }
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
    boolean isInt = true;
    try {
      data = br.readLine();
    } catch (IOException e) {
      System.out.println("Invalid input");
    }
    int dataInt = 0;
    try {
      dataInt = Integer.parseInt(data);
    } catch (NumberFormatException nfe) {
      isInt = false;
    }
    if (isInt) {
      kette.push(dataInt);
    } else {
      kette.push(data);
    }
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
    System.out.println("Press [4] to quit");
  }
}
