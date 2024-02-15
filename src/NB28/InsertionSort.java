package NB28;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int data = arr[i];
            int dataIndex = i;
            while (dataIndex > 0 && data < arr[dataIndex-1]) {
                arr[dataIndex] = arr[dataIndex-1];
                dataIndex--;
            }
            arr[dataIndex] = data;
        }
    }
}
