package NB11;

public class FindLagestNumber {
    public static int findLargestNumber(int[] array) {
        if(array.length == 0) {
            throw new IllegalStateException();
        }
        return findLargersNumber(array, 0, array[0]);
    }
    private static int findLargersNumber(int[] array, int index, int largestNumber) {
        if(index == array.length) {
            return largestNumber;
        }
            if (array[index] > largestNumber) {
                return findLargersNumber(array, index+1, array[index]);
            }else {
                return findLargersNumber(array, index+1, largestNumber);
            }
    }
}
