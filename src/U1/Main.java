package Labb1.U1;

import Labb1.U1.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        for (int i = 0; i < 4; i++) l.add("e" + i);
        l.remove(3);
        l.add(0, "Först");
        l.add("Sist");
        System.out.println(l);
    }
}
