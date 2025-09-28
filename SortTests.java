package Sorts1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class SortTests {
    private final Random rand = new Random();

    @Test
    void testEmptyArray() {
        int[] arr = {};
        Sorts1.InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{}, arr);

        Sorts1.SelectionSort.selectionSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        Sorts1.InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{42}, arr);

        arr = new int[]{42};
        Sorts1.SelectionSort.selectionSort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testDuplicates() {
        int[] arr = {5, 1, 5, 3};
        int[] expected = {1, 3, 5, 5};
        Sorts1.InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr);

        arr = new int[]{5, 1, 5, 3};
        Sorts1.SelectionSort.selectionSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testPropertyBasedRandom() {
        for (int n = 1; n <= 1000; n += 100) {
            int[] arr = rand.ints(n, 0, 10000).toArray();
            int[] copy = Arrays.copyOf(arr, arr.length);

            InsertionSort.insertionSort(arr);
            Arrays.sort(copy);
            assertArrayEquals(copy, arr);

            arr = rand.ints(n, 0, 10000).toArray();
            copy = Arrays.copyOf(arr, arr.length);
            SelectionSort.selectionSort(arr);
            Arrays.sort(copy);
            assertArrayEquals(copy, arr);
        }
    }
}


