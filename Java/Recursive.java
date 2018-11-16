class Recursive {
  public static void main(String[] args) {
    System.out.println(recurse(3));
  }

  static int sequence(int n) {
    if (n == 0) return 1;
    else {
      return 2 * recurse(n - 1);
    }
  }
}
