package U5;

public class SortBoxes {
    public static String RobotSorter(char[] boxes) {
        StringBuilder sb = new StringBuilder();
        return RobotSorter(boxes, 0, sb);
    }
    private static String RobotSorter(char[] boxes, int nrOfMoves, StringBuilder sb) {
        if(nrOfMoves > 15) {
            return "Unable to sort in under 15 moves";
        }
        if(isCorrect(boxes)) {
            return sb.toString();
        }
        bFunction(boxes);
        sb.append('b');
        String bPath = RobotSorter(boxes, nrOfMoves+1, sb);
        bFunction(boxes);

        sb.deleteCharAt(sb.length()-1);

        sFunction(boxes);
        sb.append('s');
        String sPath = RobotSorter(boxes, nrOfMoves+1, sb);
        reverseSFucntion(boxes);

        sb.deleteCharAt(sb.length()-1);

        return bPath.length() < sPath.length() ? bPath : sPath;
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
    private static void reverseSFucntion(char[] boxes) {
        char tmp = boxes[0];
        for (int i = 0; i < boxes.length-1; i++) {
            boxes[i] = boxes[i+1];
        }
        boxes[boxes.length-1] =tmp;
    }
}
