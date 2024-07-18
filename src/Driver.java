import java.util.Arrays;
import java.lang.Math;

public class Driver {
    public static void main(String[] args) {
        int[] arr = new int[1000000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000000) + 1;
        }

        // arr[0] = Integer.MAX_VALUE;
        // arr[arr.length - 1] = Integer.MIN_VALUE;

        System.out.print("Array to sort: ");
        displayArr(arr, 10, 5);

        double start, end;
        int[] test;

        // Bubble Sort
        Sorting.swaps = 0;
        test = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        Sorting.bubbleSort(test);
        end = System.currentTimeMillis();
        if (isSorted(test)) {
            System.out.println("Bubble sort took " + (end - start) / 1000 + " seconds to run with " + Sorting.swaps + " swaps");
        } else {
            System.out.println("Bubble sort failed to sort the array");
        }

        // Cocktail Shaker Sort
        Sorting.swaps = 0;
        test = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        Sorting.cocktailSort(test);
        end = System.currentTimeMillis();
        if (isSorted(test)) {
            System.out.println("Cocktail Shaker sort took " + (end - start) / 1000 + " seconds to run with " + Sorting.swaps + " swaps");
        } else {
            System.out.println("Cocktail Shaker sort failed to sort the array");
        }

        // Gnome Sort
        Sorting.swaps = 0;
        test = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        Sorting.gnomeSort(test);
        end = System.currentTimeMillis();
        if (isSorted(test)) {
            System.out.println("Gnome sort took " + (end - start) / 1000 + " seconds to run with " + Sorting.swaps + " swaps");
        } else {
            System.out.println("Gnome sort failed to sort the array");
        }

        // Selection Sort
        Sorting.swaps = 0;
        test = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        Sorting.selectionSort(test);
        end = System.currentTimeMillis();
        if (isSorted(test)) {
            System.out.println("Selection sort took " + (end - start) / 1000 + " seconds to run with " + Sorting.swaps + " swaps");
        } else {
            System.out.println("Selection sort failed to sort the array");
        }

        // Insertion Sort
        Sorting.swaps = 0;
        test = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        Sorting.insertionSort(test);
        end = System.currentTimeMillis();
        if (isSorted(test)) {
            System.out.println("Insertion sort took " + (end - start) / 1000 + " seconds to run with " + Sorting.swaps + " swaps");
        } else {
            System.out.println("Insertion sort failed to sort the array");
        }

        // Merge Sort
        Sorting.swaps = 0;
        test = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        Sorting.mergeSort(test, 0, test.length - 1);
        end = System.currentTimeMillis();
        if (isSorted(test)) {
            System.out.println("Merge sort took " + (end - start) / 1000 + " seconds to run with " + Sorting.swaps + " swaps");
        } else {
            System.out.println("Merge sort failed to sort the array");
        }

        // Quick Sort
        Sorting.swaps = 0;
        test = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        Sorting.quickSort(test, 0, test.length - 1);
        end = System.currentTimeMillis();
        if (isSorted(test)) {
            System.out.println("Quick sort took " + (end - start) / 1000 + " seconds to run with " + Sorting.swaps + " swaps");
        } else {
            System.out.println("Quick sort failed to sort the array");
        }

        // Radix Sort (LSD)
        Sorting.swaps = 0;
        test = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        Sorting.radixSortLSD(test);
        end = System.currentTimeMillis();
        if (isSorted(test)) {
            System.out.println("Radix sort (LSD) took " + (end - start) / 1000 + " seconds to run with " + Sorting.swaps + " swaps");
        } else {
            System.out.println("Radix sort (LSD) failed to sort the array");
        }

        // Radix Sort (MSD)
        Sorting.swaps = 0;
        test = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        Sorting.radixSortMSD(test);
        end = System.currentTimeMillis();
        if (isSorted(test)) {
            System.out.println("Radix sort (MSD) took " + (end - start) / 1000 + " seconds to run with " + Sorting.swaps + " swaps");
        } else {
            System.out.println("Radix sort (MSD) failed to sort the array");
        }


        // Heap Sort
        Sorting.swaps = 0;
        test = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        Sorting.heapSort(test);
        end = System.currentTimeMillis();
        if (isSorted(test)) {
            System.out.println("Heap sort took " + (end - start) / 1000 + " seconds to run with " + Sorting.swaps + " swaps");
        } else {
            System.out.println("Heap sort failed to sort the array");
        }

        // Counting Sort
        Sorting.swaps = 0;
        test = Arrays.copyOf(arr, arr.length);
        start = System.currentTimeMillis();
        Sorting.countingSort(test);
        end = System.currentTimeMillis();
        if (isSorted(test)) {
            System.out.println("Counting sort took " + (end - start) / 1000 + " seconds to run with " + Sorting.swaps + " swaps");
        } else {
            System.out.println("Counting sort failed to sort the array");
        }

    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void displayArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

    public static void displayArr(int[] arr, int front, int back) {
        assert front + back < arr.length;
        System.out.print("[");
        for (int i = 0; i < front; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("...");
        for (int i = arr.length - back; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("]");
    }
}