package NB26;

import NB25.ResizableHTB;

/**
 * ResizableHTB har både resizable metoden, samt remove och toString, alltså kan den användas för att testa NB24 och NB25
 */
public class Main {
    public static void main(String[] args) {
        ResizableHTB<Integer, Integer> HashTableBucket = new ResizableHTB<>(4);
        for (int i = 0; i < 10; i++) {
            HashTableBucket.put(i, i+10);
            if(i == 2  || i == 5)
                System.out.println(HashTableBucket.toString());
        }
        System.out.println(HashTableBucket.toString());
        HashTableBucket.remove(1); // key 1 - value 11 går bort
        HashTableBucket.remove(-1); // inget tas bort
        HashTableBucket.put(11, 10); // en ny key 11 som representerar ett värde som redan existerar
        System.out.println(HashTableBucket.toString());
    }
}
