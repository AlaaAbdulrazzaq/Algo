package NB8;

public class Main {
    public static void main(String[] args) {
        NB8_ArrayQueue<Integer> queue = new NB8_ArrayQueue<>(8);
        queue.offer(2);
        queue.offer(4);
        System.out.println(queue.toString());
        queue.offer(3);
        queue.offer(2);
        System.out.println(queue.toString());
    }
}
