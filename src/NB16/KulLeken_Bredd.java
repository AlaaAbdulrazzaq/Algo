package NB16;

import java.util.LinkedList;
import java.util.Queue;

public class KulLeken_Bredd {
    public static int ballGame(int red, int blue, int white) {
        return ballGameBredd(red, blue, white);
    }
    private static int ballGameBredd(int red, int blue, int white) {
        if(red == 0 && blue == 0 && white == 0) {
            throw new IllegalStateException();
        }
        Queue<Tillstand> queue = new LinkedList<Tillstand>();
        Tillstand t = new Tillstand(red, blue, white, 0);

        while(t.blue != t.white || t.blue != t.red) {
            if(t.blue > 0)
                queue.offer(new Tillstand(t.red + 3, t.blue-1, t.white+1, t.nrOfExchanges+1));
            if(t.white > 0)
                queue.offer(new Tillstand(t.red + 4, t.blue +2, t.white -1, t.nrOfExchanges +1));
            if (t.red > 0)
                queue.offer(new Tillstand(t.red - 1, t.blue + 1, t.white + 5, t.nrOfExchanges +1));
            t = queue.poll();
        }
        return t.nrOfExchanges;
    }
}
