package m_Damer;

public class Board {
    Square[][] board;
    public Board() {
        board = new Square[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Square();
            }
        }
    }

    public Square[][] getBoard() {
        return board;
    }

    public Square getSquare(int longitude, int latitude) {
        return this.board[longitude][latitude];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(board[i][j].toString());
                sb.append(" "); // Add space for separation
            }
            sb.append("\n"); // New line after completing a row
        }
        return sb.toString();
    }
}
