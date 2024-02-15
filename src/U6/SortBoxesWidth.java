package U6;

import java.util.LinkedList;
import java.util.Queue;

public class SortBoxesWidth {
    public static String robotSort(char[] boxes) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(boxes, "", 0)); // Initialt tillstånd

        while (!queue.isEmpty()) {
            State current = queue.poll();
            char[] currentState = current.boxes;
            String currentMoves = current.moves;

            if (isCorrect(currentState)) {
                return currentMoves; // Returnera alla moves som dragits
            }

            if (current.nrOfMoves >= 15) {
                break;
            }

            char[] newStateB = currentState.clone();
            bFunction(newStateB);
            queue.offer(new State(newStateB, currentMoves + "b", current.nrOfMoves + 1));

            char[] newStateS = currentState.clone();
            sFunction(newStateS);
            queue.offer(new State(newStateS, currentMoves + "s", current.nrOfMoves + 1));
        }

        return "Unable to sort in under 15 moves"; // Om kön töms utan lösning
    }

    static class State {
        char[] boxes;
        String moves;
        int nrOfMoves;

        State(char[] boxes, String moves, int nrOfMoves) {
            this.boxes = boxes;
            this.moves = moves;
            this.nrOfMoves = nrOfMoves;
        }
    }

    private static boolean isCorrect(char[] boxes) {
        for (int i = 0; i < boxes.length-1; i++) {
            if (boxes[i] > boxes[i+1]) {
                return false;
            }
        }
        return true;
    }
    private static void bFunction(char[] boxes) {
        char tmp = boxes[0];
        boxes[0] = boxes[1];
        boxes[1] = tmp;
    }

    private static void sFunction(char[] boxes) {
        char tmp = boxes[boxes.length-1];
        for (int i = boxes.length-1; i > 0; i--) {
            boxes[i] = boxes[i-1];
        }
        boxes[0] = tmp;
    }
}
