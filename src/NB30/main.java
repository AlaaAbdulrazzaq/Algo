package NB30;

public class main {
    public static void main(String[] args) {
        main_Heap<String> heap = new main_Heap<>(3);
        heap.insert("Gucci");
        System.out.println(heap.toString());
        heap.insert("Chanel");
        System.out.println(heap.toString());
        heap.insert("Armani");
        System.out.println(heap.toString());
        heap.insert("Cartier"); // heap bör öka i storlek till 6 platser där 4 är tagna och 2 null!!
        System.out.println(heap.toString());

    }
}
