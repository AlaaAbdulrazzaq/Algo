package NB28;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-2; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length-1; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }
}
