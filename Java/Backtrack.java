public class Backtrack {
  int[][] board = new int[5][5];
  final int DAME = 1;
  final int ALTEDAME = 2;
  final int LEER = 0;
  public static void main(String[] args) {
    Backtrack b = new Backtrack();
    b.board = b.initBoard(b.board);
    int[][] validPosition = b.getValidPos(b.board);
    for (int i = 0; i <= 1; i++) {
      System.out.print(validPosition[i][0] + " ");
    }
  }
  
  private int[][] initBoard(int[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        board[row][col] = LEER;
      }
    }
    board[0][0] = DAME;
    board[1][2] = DAME;
    return board;
  }
  
  private boolean checkValid(int[][] board, int row, int col) {
    if (board[row][col] == DAME || board[row][col] == ALTEDAME) return false;
    
      for (int itCol = 0; itCol < board.length; itCol++) if (board[row][itCol] == DAME) return false;
    
      for (int itRow = 0; itRow < board[1].length; itRow++) if (board[itRow][col] == DAME) return false;
    
    for (int itRow = 0; itRow < board.length; itRow++) {
      for (int itCol = 0; itCol < board[itRow].length; itCol++ ) {
        if (itRow + itCol == row + col && board[itRow][itCol] == DAME) return false;
        if (itRow - itCol == row - col && board[itRow][itCol] == DAME) return false;
      }
    }
    return true;
  }
  
  private int[][] getValidPos(int[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board.length; col++) {
        if (checkValid(board, row, col)) return new int[][]{{row}, {col}};
      }
    }
    return null;
  }
}
