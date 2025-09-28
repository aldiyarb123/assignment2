package Sorts1;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int pos = binarySearch(arr, key, 0, i - 1);

            int j = i - 1;
            while (j >= pos) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[pos] = key;
        }
    }

    private static int binarySearch(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
