package NB25;

public class Main {
    public static void main(String[] args) {
        ResizableHTB<String, Integer> hashMap = new ResizableHTB<>(4);
        hashMap.put("Alaa", 2);
        System.out.println(hashMap.toString());
        hashMap.put("Erik", 1);
        System.out.println(hashMap.toString());
        hashMap.put("Alfonso", 5);
        System.out.println(hashMap.toString());
        hashMap.put("Olof", 10);
        System.out.println(hashMap.toString());
        hashMap.put("Adam", 51);
        System.out.println(hashMap.toString());
        hashMap.put("bengt", 12);
        System.out.println(hashMap.toString());
        hashMap.put("Alex", 2);
        System.out.println(hashMap.toString());
        hashMap.remove("Alex");
        System.out.println(hashMap.toString());

    }
}
