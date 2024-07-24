import java.util.Arrays;

public class Sorting {
    public static long swaps = 0;
    public static long comparisons = 0;

    public static void reset() {
        swaps = 0;
        comparisons = 0;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        swaps++;
    }

    public static int min(int[] arr, int left, int right) {
        int min = arr[left];
        for (int i = left; i <= right; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int max(int[] arr, int left, int right) {
        int max = arr[left];
        for (int i = left; i <= right; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int[] minMax(int[] arr, int left, int right) {
        int[] min_max = {arr[left], arr[left]};
        for (int i = left; i < right; i++) {
            if (arr[i] < min_max[0]) {
                min_max[0] = arr[i];
            }
            if (arr[i] > min_max[1]) {
                min_max[1] = arr[i];
            }
        }
        return min_max;
    }

    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                return binarySearch(arr, target, left, mid - 1);
            } else if (target > arr[mid]) {
                return binarySearch(arr, target, mid + 1, right);
            }
        }
        return -1;
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
            comparisons++;
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

            int[] left_arr = new int[mid - left + 1];
            int[] right_arr = new int[right - mid];
            for (int i = 0; i < left_arr.length; i++) {
                left_arr[i] = arr[left + i];
            }
            for (int i = 0; i < right_arr.length; i++) {
                right_arr[i] = arr[mid + i + 1];
            }

            int idx = left, left_idx = 0, right_idx = 0;
            while (left_idx < left_arr.length && right_idx < right_arr.length) {
                if (left_arr[left_idx] <= right_arr[right_idx]) {
                    arr[idx] = left_arr[left_idx];
                    left_idx++;
                } else {
                    arr[idx] = right_arr[right_idx];
                    right_idx++;
                }
                comparisons++;
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

    public static void bubbleSort(int[] arr, int left, int right) {
        boolean swapped = true;
        int i = 0;
        while (swapped) {
            swapped = false;
            for (int n = left; n < right - i; n++) {
                if (arr[n] > arr[n + 1]) {
                    swap(arr, n, n + 1);
                    swapped = true;
                }
                comparisons++;
            }
            i++;
        }
    }

    public static void cocktailSort(int[] arr, int left, int right) {
        boolean swapped = true;
        int start = left, end = right;
        while (swapped) {
            swapped = false;
            for (int n = start; n < end; n++) {
                if (arr[n] > arr[n + 1]) {
                    swap(arr, n, n + 1);
                    swapped = true;
                }
                comparisons++;
            }
            end--;
            for (int n = end; n > start; n--) {
                if (arr[n - 1] > arr[n]) {
                    swap(arr, n - 1, n);
                    swapped = true;
                }
                comparisons++;
            }
            start++;
        }
    }

    public static void selectionSort(int[] arr, int left, int right) {
        int min, min_idx;
        for (int i = left; i < right; i++) {
            min = arr[i];
            min_idx = i;
            for (int n = i + 1; n <= right; n++) {
                if (arr[n] < min) {
                    min = arr[n];
                    min_idx = n;
                }
                comparisons++;
            }
            swap(arr, i, min_idx);
        }
    }

    public static void insertionSort(int[] arr, int left, int right) {
        int n, temp;
        for (int i = left; i <= right; i++) {
            n = 0;
            temp = arr[i];
            while (arr[n] <= temp && n < i) {
                comparisons++;
                n++;
            }
            for (int j = i; j > n; j--) {
                arr[j] = arr[j - 1];
                swaps++;
            }
            arr[n] = temp;
            swaps++;
        }
    }

    public static void binaryInsertionSort(int[] arr, int left, int right) {
        int l, r, n, temp;
        for (int i = left; i <= right; i++) {
            temp = arr[i];

            l = 0;
            r = i;
            n = l + (r - l) / 2;
            while (arr[n] != temp && l <= r) {
                if (temp < arr[n]) {
                    r = n - 1;
                } else {
                    l = n + 1;
                }
                comparisons++;
                n = l + (r - l) / 2;
            }

            for (int j = i; j > n; j--) {
                arr[j] = arr[j - 1];
                swaps++;
            }
            arr[n] = temp;
            swaps++;
        }
    }

    public static void radixSortLSD(int[] arr, int left, int right) {
        int[] out, counts;
        int digit;

        int max = max(arr, left, right);
        for (int i = 1; max / i > 0; i *= 10) {
            out = new int[right - left + 1];
            counts = new int[19];
            for (int n = left; n <= right; n++) {
                digit = arr[n] / i % 10;
                counts[digit + 9]++;
            }
            for (int n = 1; n < counts.length; n++) {
                counts[n] += counts[n - 1];
            }
            for (int n = right; n >= left; n--) {
                digit = arr[n] / i % 10;
                out[counts[digit + 9] - 1] = arr[n];
                counts[digit + 9]--;
            }
            for (int n = left; n <= right; n++) {
                arr[n] = out[n - left];
            }
        }
    }

    public static void radixSortMSD(int[] arr, int left, int right) {
        int p = 1, max = max(arr, left, right);
        while (max / p > 9) {
            p *= 10;
        }
        radixSortMSD(arr, left, right, p);
    }

    public static void radixSortMSD(int[] arr, int left, int right, int p) {
        if (p > 0 && right - left > 0) {
            int[] out = new int[right - left + 1], counts = new int[19], ends;
            int digit;
            for (int i = left; i <= right; i++) {
                digit = arr[i] / p % 10;
                counts[digit + 9]++;
            }
            for (int i = 1; i < counts.length; i++) {
                counts[i] += counts[i - 1];
            }
            ends = Arrays.copyOf(counts, counts.length);
            for (int i = right; i >= left; i--) {
                digit = arr[i] / p % 10;
                out[counts[digit + 9] - 1] = arr[i];
                counts[digit + 9]--;
            }
            for (int i = left; i <= right; i++) {
                arr[i] = out[i - left];
            }
            for (int i = 0; i < counts.length; i++) {
                radixSortMSD(arr, counts[i] + left, ends[i] + left - 1, p / 10);
            }
        }
    }

    public static void countingSort(int[] arr, int left, int right, int min, int max) {
        int[] out = new int[right - left + 1];
        int[] counts = new int[max - min + 1];
        for (int i = left; i <= right; i++) {
            counts[arr[i] - min]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        for (int i = right; i >= left; i--) {
            out[counts[arr[i] - min] - 1] = arr[i];
            counts[arr[i] - min]--;
        }
        for (int i = left; i <= right; i++) {
            arr[i] = out[i];
        }
    }

    public static void countingSort(int[] arr, int left, int right) {
        int[] min_max = minMax(arr, left, right);
        int min = min_max[0], max = min_max[1];
        countingSort(arr, left, right, min, max);
    }

    public static void gnomeSort(int[] arr, int left, int right) {
        int i = left;
        while (i <= right) {
            if (i == left) {
                i++;
            } else if (arr[i - 1] > arr[i]) {
                swap(arr, i - 1, i);
                i--;
            } else {
                i++;
            }
            comparisons++;
        }
    }

    public static void maxHeapify(int[] arr, int root, int size) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int max = root;
        if (left < size && arr[max] < arr[left]) {
            max = left;
        } else if (left < size) comparisons++;

        if (right < size && arr[max] < arr[right]) {
            max = right;
        } else if (right < size) comparisons++;

        if (max != root) {
            swap(arr, root, max);
            maxHeapify(arr, max, size);
        }
    }

    public static void heapSort(int[] arr, int left, int right) {
        for (int i = right; i >= left; i--) {
            maxHeapify(arr, i, right - left + 1);
        }

        for (int i = right; i >= left; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
    }

    public static void shellSort(int[] arr, int left, int right) {
        
    }

    public static void bitonicSort(int[] arr, int left, int right) {
        
    }

    public static void combSort(int[] arr, int left, int right) {
        
    }
}