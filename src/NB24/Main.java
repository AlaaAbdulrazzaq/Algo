package NB24;

public class Main {
    public static void main(String[] args) {
        HTB_ToStringRemove<String, Integer> hashMap = new HTB_ToStringRemove<>(5);
        hashMap.put("Alaa", 2);
        hashMap.put("Erik", 1);
        hashMap.put("Alfonso", 5);
        hashMap.put("Olof", 10);
        System.out.println(hashMap.toString());
        hashMap.put("Adam", 51);
        hashMap.put("bengt", 12);
        hashMap.put("Alex", 2);
        System.out.println(hashMap.toString());
        hashMap.remove("Alex");
        System.out.println(hashMap.toString());


    }
}
