class Recursive {
  public static void main(String[] args) {
    System.out.println(sequence(3, 2));
    System.out.println(pascalTriangle(4, 2));
    System.out.println(fibonacci(10));
  }

  static int sequence(int n, int factor) {
    if (n == 0) return 1;
    else {
      return factor * sequence(n - 1, factor);
    }
  }

  static int pascalTriangle(int row, int col) {
    if (row == col || col <= 1) return 1;
    else if (col > row) {
      printInvalidInput();
      return 0;
    }
    else return pascalTriangle(row - 1, col) + pascalTriangle(row - 1, col - 1);
  }

  static int fibonacci(int n) {
    if (n == 0) return 0;
    else if (n == 1) return 1;
    else return fibonacci(n - 1) + fibonacci(n - 2);
  }

  static void printInvalidInput() {
    System.out.println("Row can't be larger than column");
  }
}
