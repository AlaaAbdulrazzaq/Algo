package NB19;

import java.util.List;

public class main {
    public static void main(String[] args) {
        SquareGame game = new SquareGame();

        // Testing the initial state of the board
        System.out.println("Initial State: " + game.toString());

        // Solving the game
        List<String> solutions = game.solve();
        System.out.println("Found " + solutions.size() + " solution(s).");

        // Printing each solution
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("Solution " + (i + 1) + ": " + solutions.get(i));
        }
    }
}

// Don't forget to include the SquareGame class definition here, or in a separate file
