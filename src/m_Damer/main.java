package m_Damer;

public class main {
    public static void main(String[] args) {
        queenPlacement b = new queenPlacement(8);
        b.solveNQueens();
        System.out.println(b.chessBoard.toString());
    }
}
