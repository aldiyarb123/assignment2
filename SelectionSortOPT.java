package Test;
import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    private static int comparisons = 0;
    private static int swaps = 0;
    private static int accesses = 0;

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            swapped = false;

            for (int j = i + 1; j < n; j++) {
                comparisons++;
                accesses += 2;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    swapped = true;
                }
            }

            if (swapped) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                swaps++;
                accesses += 4;
            } else {
                break;
            }
        }
    }

    public static void resetMetrics() {
        comparisons = swaps = accesses = 0;
    }

    public static void printMetrics() {
        System.out.println("Selection Sort Metrics -> Comparisons: " + comparisons +
                ", Swaps: " + swaps +
                ", Accesses: " + accesses);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java SelectionSort <size> <random|sorted|reverse|duplicates>");
            return;
        }

        int size = Integer.parseInt(args[0]);
        String type = args[1];
        int[] arr = generateArray(size, type);

        resetMetrics();
        selectionSort(arr);
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
                for (int i = 0; i < size; i++) arr[i] = rand.nextInt(3);
                break;
            case "random":
            default:
                for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }
}


