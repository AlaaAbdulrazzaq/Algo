package U2;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        LinkedList2<String> l = new LinkedList2<>();
        for (int i = 0; i < 4; i++) l.add(i,"e" + i);
        Iterator<String> iter = l.iterator();
        iter.next();
        iter.next();
        iter.remove();
        iter.next();
        iter.remove();
        System.out.println(l);
    }
}