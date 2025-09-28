package Test;
import java.util.Arrays;
import java.util.Random;


public class InsertionSort {
    private static int comparisons = 0;
    private static int shifts = 0;
    private static int accesses = 0;

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            accesses++;

            int pos = binarySearch(arr, key, 0, i - 1);

            int j = i - 1;
            while (j >= pos) {
                arr[j + 1] = arr[j];
                shifts++;
                accesses++;
                j--;
            }
            arr[pos] = key;
            accesses++;
        }
    }

    private static int binarySearch(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            accesses++;
            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void resetMetrics() {
        comparisons = shifts = accesses = 0;
    }

    public static void printMetrics() {
        System.out.println("Insertion Sort Metrics -> Comparisons: " + comparisons +
                ", Shifts: " + shifts +
                ", Accesses: " + accesses);
    }


    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java InsertionSort <size> <random|sorted|reverse|duplicates>");
            return;
        }

        int size = Integer.parseInt(args[0]);
        String type = args[1];
        int[] arr = generateArray(size, type);

        resetMetrics();
        insertionSort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
        printMetrics();
    }

    private static int[] generateArray(int size, String type) {
        int[] arr = new int[size];
        Random rand = new Random();

        switch (type.toLowerCase()) {
            case "sorted":
                for (int i = 0; i < size; i++) arr[i] = i;
                break;
            case "reverse":
                for (int i = 0; i < size; i++) arr[i] = size - i;
                break;
            case "duplicates":
                for (int i = 0; i < size; i++) arr[i] = rand.nextInt(3); // many repeats
                break;
            case "random":
            default:
                for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }
}

