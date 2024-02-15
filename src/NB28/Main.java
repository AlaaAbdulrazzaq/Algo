package NB28;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[7];
        for (int i = 0; i < 7; i++) {
            array[i] = 10-i;
        }


        InsertionSort.insertionSort(array);

        for (int i = 0; i < 7; i++) {
            System.out.println(array[i]);
        }

        int[] array2 = new int[7];
        for (int i = 0; i < 7; i++) {
            array2[i] = 20-i;
        }
        System.out.println("\n");

        SelectionSort.selectionSort(array2);
        for (int i = 0; i < 7; i++) {
            System.out.println(array2[i]);
        }
    }
}
