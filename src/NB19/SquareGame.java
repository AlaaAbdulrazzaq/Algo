package NB19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SquareGame {
    private enum square{DARK, LIGHT, EMPTY};
    private square[] line;
    public SquareGame() {
        line = new square[7];
        for (int i = 0; i < 3; i++) {
            line[i] = square.DARK;
        }
        line[3] = square.EMPTY; // Set the empty square at index 3
        for (int i = 4; i < 7; i++) {
            line[i] = square.LIGHT;
        }
    }


    private boolean isSolved() {
        for (int i = 0; i < line.length; i++) {
            if(i<3){
                if(line[i] != square.LIGHT)
                    return false;
            }
            if(i == 3) {
                if(line[i] != square.EMPTY)
                    return false;
            }
            if(i > 3) {
                if(line[i] != square.DARK)
                    return false;
            }
        }
        return true;
    }
    public List<String> solve() {
        return solve("",0);
    }
    private List<String> solve(String moves, int position) {
        List<String> sequences = new ArrayList<>();

        if (isSolved()) {
            sequences.add(moves);
            return sequences;
        }
        System.out.println("inne");
        for (int i = position; i < line.length; i++) {
            if (canMoveForward(i)) {
                String newMoves = moves + " Move forward at " + i;
                square temp = line[i];
                line[i] = line[i + 1];
                line[i + 1] = temp;

                sequences.addAll(solve(newMoves, i + 1));

                line[i + 1] = line[i];
                line[i] = temp;
            }

            if (canJumpOver(i)) {
                String newMoves = moves + " Jump over at " + i;
                square temp = line[i];
                line[i] = line[i + 2];
                line[i + 2] = temp;

                sequences.addAll(solve(newMoves, i + 2));

                line[i + 2] = line[i];
                line[i] = temp;
            }
        }

        return sequences;
    }

    private boolean canMoveForward(int position) {
        if (position >= line.length - 1) {
            return false;
        }
        return (line[position] == square.DARK || line[position] == square.LIGHT) && line[position + 1] == square.EMPTY;
    }

    private boolean canJumpOver(int position) {
        if (position >= line.length - 2) {
            // Cannot jump if it's the second-to-last or last element
            return false;
        }

        if (line[position] == square.DARK && line[position + 1] == square.LIGHT && line[position + 2] == square.EMPTY) {
            return true;
        } else if (line[position] == square.LIGHT && line[position + 1] == square.DARK && line[position + 2] == square.EMPTY) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (square sq : line) {
            if (sq == null) {
                sb.append("X "); // Representing uninitialized or null squares
                continue;
            }
            switch (sq) {
                case DARK:
                    sb.append("D ");
                    break;
                case LIGHT:
                    sb.append("L ");
                    break;
                case EMPTY:
                    sb.append("_ ");
                    break;
            }
        }
        return sb.toString().trim();
    }



// Helper methods for canMoveForward and canJumpOver...

}
