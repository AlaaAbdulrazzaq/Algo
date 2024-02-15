package NB14_1;

public class Kulleken {
    public static int ballGame(int red, int blue, int white){
        return ballGameRecursive(red, blue, white, 0);
    }

    /**
     *  1 blå kula kan växlas mot 1 vit kula och 3 röda kulor.
     *  1 vit kula kan växlas mot 2 blåa kulor och 4 röda kulor.
     *  1 röd kula kan växlas mot 1 blå kula och 5 vita kulor.
     * @param red
     * @param blue
     * @param white
     * @param nrOfExchanges
     * @return
     */

    private static int ballGameRecursive(int red, int blue, int white, int nrOfExchanges) {
        // Base case: if all colors have the same number of balls
        if (red == blue && blue == white) {
            return nrOfExchanges;
        }

        // Failsafe to prevent infinite recursion
        if (nrOfExchanges >= 15 || red < 0 || blue < 0 || white < 0) {
            return Integer.MAX_VALUE;
        }

        // Perform exchanges and recurse
        int minExchanges = Integer.MAX_VALUE;
        minExchanges = Math.min(minExchanges, ballGameRecursive(red - 1, blue + 1, white + 5, nrOfExchanges + 1)); // Exchange red
        minExchanges = Math.min(minExchanges, ballGameRecursive(red + 4, blue + 2, white - 1, nrOfExchanges + 1)); // Exchange white
        minExchanges = Math.min(minExchanges, ballGameRecursive(red + 3, blue - 1, white + 1, nrOfExchanges + 1)); // Exchange blue

        return minExchanges;
    }
}