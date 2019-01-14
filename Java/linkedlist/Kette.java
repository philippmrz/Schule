import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kette {
  Knoten kopf = new Knoten(null, null, "Kopf");
  Knoten ende = new Knoten(kopf, null, "Ende");

  public static void main(String[] args) {
    Kette kette = initialize();
    kette.print();
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
          swapPointers(kette, knoten, null);
          isSorted = false;
        }
        knoten = knoten.successor;
      }
    }
    System.out.println("Sorted:");
    kette.print();
  }

  private void insertionSort(Kette kette) {
    Knoten knoten = kopf.successor.successor;
    Object numToInsert;                                       
    while (knoten.successor != null && knoten.data != "Ende") {
      numToInsert = knoten.data;
      Knoten backwardsKnot = knoten.predecessor;
      while (backwardsKnot != null && backwardsKnot.data != "Kopf" && (int) backwardsKnot.data > (int) numToInsert) {;
        //backwardsKnot.successor.data = backwardsKnot.data;
        backwardsKnot = backwardsKnot.predecessor;
        kette.print();
      }
      knoten.predecessor.successor = knoten.successor;
      knoten.successor.predecessor = knoten.predecessor;
      
      knoten.predecessor = backwardsKnot;
      knoten.successor = backwardsKnot.successor;
      backwardsKnot.successor.predecessor = knoten;
      backwardsKnot.successor = knoten;
      
      knoten = knoten.successor;
    }
  }
  
  private void selectionSort(Kette kette) {
    Knoten knoten = kopf.successor;
    Knoten findMin;
    Object currentLowest = kopf.successor.data;
    while (knoten != ende) {
      findMin = knoten;    
      while (findMin != ende) if (findMin.data < currentLowest) currentLowest = findMin.data;
      //kette.swapPointers()
      knoten = knoten.successor;
    }
  }

  private void swapPointers(Kette kette, Knoten knoten1, Knoten knoten2) {
    if (knoten2 == null) {
      Knoten tmpKnoten = knoten1.successor.successor;
      knoten1.predecessor.successor = knoten1.successor;
      knoten1.successor.predecessor = knoten1.predecessor;
      knoten1.successor.successor = knoten1;
      knoten1.predecessor = knoten1.successor;
      knoten1.successor = tmpKnoten;
      tmpKnoten.predecessor = knoten1;
    } else {
      Knoten knoten1pre = knoten1.predecessor;
      Knoten knoten1post = knoten1.successor;
      
      knoten1.predecessor.successor = knoten2;
      knoten1.predecessor = knoten2.predecessor;
      knoten1.successor.predecessor = knoten2;
      knoten1.successor = knoten2.successor;
      System.out.println("Knoten 1: " + knoten1.data);
      System.out.println("Knoten 2: " + knoten2.data);
      System.out.println("Knoten 2 predecessor: " + knoten2.predecessor.data);
      System.out.println("Knoten 2 predecessor successor: " + knoten2.predecessor.successor.data);
      knoten2.predecessor.successor = knoten1;
      knoten2.predecessor = knoten1pre;
      knoten2.successor.predecessor = knoten1;
      knoten2.successor = knoten1post;
    }
    System.out.println("Swapped");
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
          kette.insertionSort(kette);
          break;
        case "6":
          kette.selectionSort(kette);
          break;
        case "7":
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
    
    kette.push(1);
    kette.push(2);
    kette.push(3);
    kette.push(4);
    
    System.out.println("Filled list: ");
    return kette;
  }

  private static void printOptions() {
    System.out.println("Press [1] to print current chain");
    System.out.println("Press [2] to pop element");
    System.out.println("Press [3] to push element");
    System.out.println("Press [4] to bubble sort");
    System.out.println("Press [5] to insertion sort");
    System.out.println("Press [6] to selection sort");
    System.out.println("Press [7] to quit");
  }
}