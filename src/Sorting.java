public class Sorting {
    public static long swaps = 0;

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        swaps++;
    }

    public static void quickSort(int[] arr, int left, int right) {
        int pivot = arr[right];

        int pivot_idx = left;
        int idx = left;
        while (idx < right) {
            if (arr[idx] < pivot) {
                swap(arr, pivot_idx, idx);
                pivot_idx++;
            }
            idx++;
        }
        swap(arr, pivot_idx, right);

        if (pivot_idx - left > 1) {
            quickSort(arr, left, pivot_idx - 1);
        }
        if (right - pivot_idx > 1) {
            quickSort(arr, pivot_idx + 1, right);
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Copying the sections into right and left arrays
            int[] left_arr = new int[mid - left + 1];
            int[] right_arr = new int[right - mid];
            for (int i = 0; i < left_arr.length; i++) {
                left_arr[i] = arr[left + i];
            }
            for (int i = 0; i < right_arr.length; i++) {
                right_arr[i] = arr[mid + i + 1];
            }

            // Merging the left and right arrays
            int idx = left, left_idx = 0, right_idx = 0;
            while (left_idx < left_arr.length && right_idx < right_arr.length) {
                if (left_arr[left_idx] <= right_arr[right_idx]) {
                    arr[idx] = left_arr[left_idx];
                    left_idx++;
                } else {
                    arr[idx] = right_arr[right_idx];
                    right_idx++;
                }
                idx++;
            }

            for (int i = left_idx; i < left_arr.length; i++) {
                arr[idx] = left_arr[i];
                idx++;
            }
            for (int i = right_idx; i < right_arr.length; i++) {
                arr[idx] = right_arr[i];
                idx++;
            }
        }

    }

    public static void bubbleSort(int[] arr) {
        boolean swapped = true;
        int i = 0;
        while (swapped) {
            swapped = false;
            for (int n = 0; n < arr.length - 1 - i; n++) {
                if (arr[n] > arr[n + 1]) {
                    swap(arr, n, n + 1);
                    swapped = true;
                }
            }
            i++;
        }
    }

    public static void cocktailSort(int[] arr) {
        boolean swapped = true;
        int start = 0, end = arr.length - 1;
        while (swapped) {
            swapped = false;
            for (int n = start; n < end; n++) {
                if (arr[n] > arr[n + 1]) {
                    swap(arr, n, n + 1);
                    swapped = true;
                }
            }
            end--;
            for (int n = end; n > start; n--) {
                if (arr[n - 1] > arr[n]) {
                    swap(arr, n - 1, n);
                    swapped = true;
                }
            }
            start++;
        }
    }

    public static void selectionSort(int[] arr) {
        int min, min_idx;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            min_idx = i;
            for (int n = i + 1; n < arr.length; n++) {
                if (arr[n] < min) {
                    min = arr[n];
                    min_idx = n;
                }
            }
            swap(arr, i, min_idx);
        }
    }

    public static void insertionSort(int[] arr) {
        int n, temp;
        for (int i = 0; i < arr.length; i++) {
            n = 0;
            temp = arr[i];
            while (arr[n] <= temp && n < i) {
                n++;
            }
            for (int j = i; j > n; j--) {
                arr[j] = arr[j - 1];
            }
            arr[n] = temp;
        }
    }

    public static void radixSortLSD(int[] arr) {
        int[] out;
        int digit;

        int max = arr[0];
        for (int i: arr) {
            if (i > max) {
                max = i;
            }
        }
        for (int i = 1; max / i > 0; i *= 10) {
            out = new int[arr.length];
            int[] counts = new int[19];
            for (int n: arr) {
                digit = n / i % 10;
                counts[digit + 9]++;
            }
            for (int n = 1; n < counts.length; n++) {
                counts[n] += counts[n - 1];
            }
            for (int n = arr.length - 1; n > -1; n--) {
                digit = arr[n] / i % 10;
                out[counts[digit + 9] - 1] = arr[n];
                counts[digit + 9]--;
            }
            for (int n = 0; n < arr.length; n++) {
                arr[n] = out[n];
            }
        }
    }

    public static void radixSortMSD(int[] arr) {

    }

    public static void countingSort(int[] arr, int min, int max) {
        int[] out = new int[arr.length];
        int[] counts = new int[max - min + 1];
        for (int i: arr) {
            counts[i - min]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        for (int i = arr.length - 1; i > -1; i--) {
            out[counts[arr[i] - min] - 1] = arr[i];
            counts[arr[i] - min]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = out[i];
        }
    }

    public static void countingSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] out = new int[arr.length];
        int[] counts = new int[max - min + 1];
        for (int i: arr) {
            counts[i - min]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        for (int i = arr.length - 1; i > -1; i--) {
            out[counts[arr[i] - min] - 1] = arr[i];
            counts[arr[i] - min]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = out[i];
        }
    }

    public static void gnomeSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (i == 0) {
                i++;
            } else if (arr[i - 1] > arr[i]) {
                swap(arr, i - 1, i);
                i--;
            } else {
                i++;
            }
        }
    }

    public static void shellSort(int[] arr) {

    }

    public static void maxHeapify(int[] arr, int root, int size) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int max = root;
        if (left < size && arr[max] < arr[left]) {
            max = left;
        }
        if (right < size && arr[max] < arr[right]) {
            max = right;
        }
        if (max != root) {
            swap(arr, root, max);
            maxHeapify(arr, max, size);
        }
    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length - 1; i > -1; i--) {
            maxHeapify(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > -1; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
    }
}