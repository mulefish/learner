package learner;

public class Board {
    public int[][] board;
    int initialRow;
    int initialCol;
    int targetR;
    int targetC;
    String space = " ";
    public Board(int initialRow, int initialCol, int rows, int cols) {
        this.initialRow = initialRow;
        this.initialCol = initialCol;
        board = new int[rows][cols];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = 0;
            }
        }
        targetR = rows - 1;
        targetC = cols - 1;
        board[targetR][targetC] = 100;
    }

    public void setFootsteps(int row, int col) {
        board[row][col]++;
    }

    public void  showBoard() {
        StringBuilder ascii = new StringBuilder();
        for (int r = 0; r < board.length;    r++) {
            for (int c = 0; c < board[r].length; c++) {
                if ( r == targetR &&  c == targetC ) {
                    ascii.append(space).append("!");
                } else if ( r == initialRow && c == initialCol ) {
                    ascii.append(space).append("X");
                } else {
                    int v = board[r][c];
                    if (v > 0) {
                        ascii.append(space).append(v);
                    } else {
                        ascii.append(space).append(".");
                    }
                }
            }
            ascii.append("\n");
        }
        System.out.println(ascii);
    }



}

