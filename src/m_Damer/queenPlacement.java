package m_Damer;

public class queenPlacement {
    int nrOfQueens;
    Board chessBoard;

    public queenPlacement(int nrOfQueens) {
        this.nrOfQueens = nrOfQueens;
        chessBoard = new Board();
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < col; i++) {
            if (chessBoard.getSquare(row, i).getStateOfSquare().equals(State.QUEEN)) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard.getSquare(i, j).getStateOfSquare().equals(State.QUEEN)) {
                return false;
            }
        }
        for (int i = row, j = col; i < chessBoard.getBoard().length && j >= 0; i++, j--) {
            if (chessBoard.getSquare(i, j).getStateOfSquare().equals(State.QUEEN)) {
                return false;
            }
        }
        return true;
    }

    public boolean placeQueens(int col) {
        if (col >= nrOfQueens) return true; // Adjusted to consider nrOfQueens instead of fixed board size

        for (int i = 0; i < chessBoard.getBoard().length; i++) {
            if (isSafe(i, col)) {
                chessBoard.getSquare(i, col).setStateOfSquare(State.QUEEN);
                if (placeQueens(col + 1)) {
                    return true; // Found a valid placement for all queens
                }
                chessBoard.getSquare(i, col).setStateOfSquare(State.SAFE); // Backtrack
            }
        }
        return false; // No valid placement found for a queen in this column
    }

    public void solveNQueens() {
        if (!placeQueens(0)) {
            System.out.println("Solution does not exist");
        } else {
            printSolution();
        }
    }

    private void printSolution() {
        for (int i = 0; i < chessBoard.getBoard().length; i++) {
            for (int j = 0; j < chessBoard.getBoard()[0].length; j++) {
                System.out.print(chessBoard.getSquare(i,j).getStateOfSquare() == State.QUEEN ? " Q " : " . ");
            }
            System.out.println();
        }
    }
}
