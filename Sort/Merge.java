package Sort;

import java.util.Arrays;

import Arrays.ArrayGen;

public class Merge {

    public static void sort(int[] arr) {
        sortArray(arr, 0, arr.length - 1);
    }
    
    public static int[] sorted(int[] arr) {
        return sortArrayS(arr);
    }

    private static void sortArray(int[] arr, int l, int r) {

        System.out.println("Rcvd array: " + Arrays.toString(arr) + " from " + l + " to " + r);

        if (l < r) {

            int mid = l + (r - l) / 2;

            sortArray(arr, l, mid);
            sortArray(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }

    }

    private static void merge(int[] arr, int l, int mid, int r){

        int l1, l2;

        int[] lArr = Arrays.copyOfRange(arr, l, mid + 1);
        int[] rArr = Arrays.copyOfRange(arr, mid + 1, r + 1);

        l1 = lArr.length;
        l2 = rArr.length;

        int i = 0, j = 0;
        int k = l;

        while (i < l1 && j < l2) {
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }

        while (i < l1) {
            arr[k] = lArr[i];
            i++;
            k++;
        }

        while (j < l2) {
            arr[k] = rArr[j];
            j++;
            k++;
        }

    }

    private static int[] sortArrayS(int[] arr) { // , int l, int r) {


        int l1 = 0;
        int r1 = arr.length - 1;

        if (arr.length == 2) {
            if (arr[0] > arr[1]) {
                return new int[] { arr[1], arr[0] };
            } else {
                return arr;
            }
        }

        if (l1 < r1) {

            int mid1 = l1 + (r1 - l1) / 2;

            int[] arr1T = Arrays.copyOfRange(arr, l1, mid1);
            int[] arr2T = Arrays.copyOfRange(arr, mid1, r1 + 1);

            System.out.println("arr1 b4: " + Arrays.toString(arr1T));
            System.out.println("arr2 b4: " + Arrays.toString(arr2T));

            int[] arr1 = sortArrayS(arr1T); // , l1, mid1);

            System.out.println("Finished with the first one, now for the second");
            System.out.println("arr2 after arr1: " + Arrays.toString(arr2T));

            int[] arr2 = sortArrayS(arr2T); // , mid1 + 1, r1);

            System.out.println("arr1 after: " + Arrays.toString(arr1));
            System.out.println("arr2 after: " + Arrays.toString(arr2));

            int[] arr3 = merger(arr1, arr2, l1, mid1, r1);
            // System.out.println("Merged = ");
            return arr3;
        } else {
            return arr;
        }

        // return null;

    }

    private static int[] merger(int[] arr1, int[] arr2, int l, int mid, int r) {

        int l1, l2;

        l1 = arr1.length;
        l2 = arr2.length;

        int[] arrer = new int[l1 + l2];

        int i = 0, j = 0;
        int k = 0;

        while (i < l1 && j < l2) {
            if (arr1[i] <= arr2[j]) {
                arrer[k] = arr1[i];
                i++;
            } else {
                arrer[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < l1) {
            arrer[k] = arr1[i];
            i++;
            k++;
        }

        while (j < l2) {
            arrer[k] = arr2[j];
            j++;
            k++;
        }

        return arrer;

    }

    public static void main(String[] args) throws Exception {

        int[] x = ArrayGen.generateArray(5, 20, false);

        System.out.println("Generated Array: " + Arrays.toString(x));

        sort(x);

        System.out.println("Final Array: " + Arrays.toString(x));

    }
}
