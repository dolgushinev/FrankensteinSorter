import java.util.Arrays;

import static java.util.Arrays.copyOfRange;

public class FrankensteinSorter {

    static int depth = 0;
    static int length = 0;

    public static int[] sort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);

    }

    static int[] quickSort(int[] arr, int l, int r) {
        if (depth == 0) length = arr.length;

        depth++;

        if (arr.length <= 10) {
            bubbleSort(arr);
            return arr;
        }

/*        if (depth > Math.log(length)) {
            int[] copy = Arrays.copyOfRange(arr, l, r + 1);
            copy = mergeSort(copy);
            for (int i = l, j = 0; i < r + 1; i++, j++) {
                arr[i] = copy[j];
            }
            return mergeSort(copy);
        }*/

        if (l >= r) {
            return arr;
        }
        int mid = partition(arr, l, r);
        quickSort(arr, l, mid - 1);
        quickSort(arr, mid, r);
        return arr;
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[((l + r) / 2)];
        int i = l, j = r;

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

    static void bubbleSort(int[] arr) {
        while (true) {
            boolean wasSwap = false;
            for (int i = 0; i < arr.length - 1; ++i) {
                if (arr[i + 1] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    wasSwap = true;
                }
            }
            if (!wasSwap) break;
        }
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length <= 10) {
            bubbleSort(arr);
            return arr;
        }
        //if (arr.length == 1) return arr;
        int left_size = arr.length / 2;
        int right_size = arr.length - left_size;
        int[] left = new int[left_size];
        int[] right = new int[right_size];

        left = copyOfRange(arr, 0, arr.length / 2);

        right = copyOfRange(arr, arr.length / 2, arr.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, z = 0; // i - первый элемент left, j - первый элемент right

        while (i < left.length || j < right.length) {
            if (i < left.length && (j == right.length || left[i] < right[j])) {
                result[z] = left[i];
                i++;
            } else {
                result[z] = right[j];
                j++;
            }
            z++;
        }
        return result;
    }

}
