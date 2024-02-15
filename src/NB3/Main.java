package F2.NB3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //skapar alla noder
        Node Gilgamesh = new Node("Gilgamesh ");
        Node löper = new Node("löper ");
        Node På = new Node("på ");
        Node Stäppen = new Node("stäppen ");

        //Länkar ihop alla noder i ordning.
        Gilgamesh.next = löper;
        löper.next = På;
        På.next = Stäppen;

        //tar bort på genom att länka ihop löper och Stäppen.
        löper.next = Stäppen;

        Node current = Gilgamesh;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("\n");

        //ny lista skapas
        Node och = new Node("Och ");
        Node Nicklas = new Node("Nicklas ");
        Node ger = new  Node("ger ");
        Node Alaa = new Node("Alaa ");
        Node Godkänt = new Node("godkänt :D");
        //länkar ihop listan
        och.next = Nicklas;
        Nicklas.next = ger;
        ger.next = Alaa;
        Alaa.next = Godkänt;

        //länkar ihop listorna
        Stäppen.next = och;


        current = Gilgamesh;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("\n");


        //kapar upp listan
        Gilgamesh.next = ger;
        current = Gilgamesh;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
