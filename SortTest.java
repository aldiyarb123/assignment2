package Test;
import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[][] testCases = {
                {},
                {5},
                {3, 3, 3},
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {5, 2, 4, 6, 1, 3}
        };

        System.out.println("=== Testing Insertion Sort ===");
        for (int[] arr : testCases) {
            int[] copy = Arrays.copyOf(arr, arr.length);
            InsertionSort.resetMetrics();
            InsertionSort.insertionSort(copy);
            System.out.println("Input: " + Arrays.toString(arr) +
                    " -> Sorted: " + Arrays.toString(copy));
            InsertionSort.printMetrics();
        }

        System.out.println("\n=== Testing Selection Sort ===");
        for (int[] arr : testCases) {
            int[] copy = Arrays.copyOf(arr, arr.length);
            SelectionSort.resetMetrics();
            SelectionSort.selectionSort(copy);
            System.out.println("Input: " + Arrays.toString(arr) +
                    " -> Sorted: " + Arrays.toString(copy));
            SelectionSort.printMetrics();
        }
    }
}
