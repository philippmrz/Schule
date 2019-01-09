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

  private void bubbleSort(Kette kette) {
    Knoten knoten;
    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;
      knoten = kopf.successor;
      while (knoten.successor != null && knoten.successor.data != "Ende") {
        if ((int) knoten.data > (int) knoten.successor.data) {
          swapPointers(kette, knoten);
          isSorted = false;
        }
        knoten = knoten.successor;
      }
    }
    System.out.println("Sorted:");
    kette.print();
  }

  private void swapPointers(Kette kette, Knoten knoten) {
    Knoten tmpKnoten = knoten.successor.successor;
    knoten.predecessor.successor = knoten.successor;
    knoten.successor.predecessor = knoten.predecessor;
    knoten.successor.successor = knoten;
    knoten.predecessor = knoten.successor;
    knoten.successor = tmpKnoten;
    tmpKnoten.predecessor = knoten;
  }

  private Knoten pop() {
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

  private void push(Object data) {
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
        kette.bubbleSort(kette);
        break;
      case "5":
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

  private void print() {
    Knoten knoten = kopf;
    int index = 1;
    while (knoten != null) {
      System.out.println(index + ": " + knoten.data + " ");
      index++;
      knoten = knoten.successor;
    }
    System.out.println();
  }

  private void pushCLI(BufferedReader br, Kette kette) {
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

  private static Kette initialize() {
    Kette kette = new Kette();
    kette.kopf.successor = kette.ende;
    kette.push(34);
    kette.push(43);
    kette.push(3);
    kette.push(-3);
    kette.push(0);
    kette.push(10120);
    return kette;
  }

  private static void printOptions() {
    System.out.println("Press [1] to print current chain");
    System.out.println("Press [2] to pop element");
    System.out.println("Press [3] to push element");
    System.out.println("Press [4] to bubble sort");
    System.out.println("Press [5] to quit");
  }
}
