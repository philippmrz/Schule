class Recursive {
  public static void main(String[] args) {
    // System.out.println(sequence(3));
    System.out.println(pascalTriangle(1, 2));
  }

  static int sequence(int n) {
    if (n == 0) return 1;
    else {
      return 2 * sequence(n - 1);
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

  static void printInvalidInput() {
    System.out.println("Row can't be larger than column");
  }
}
