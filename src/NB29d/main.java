package NB29d;

import NB30.main_Heap;

public class main {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 8, 1, 3, 10, 13, 2};
        main_Heap<Integer> Heap = new main_Heap<>(10);
        heapSort(arr, Heap);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
    public static void heapSort(int[] arr, main_Heap<Integer> heap) {
        for (int item : arr) {
            heap.insert(item);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.extract();
        }
    }
}
