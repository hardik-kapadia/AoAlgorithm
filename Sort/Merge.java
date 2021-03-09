package Sort;

import Arrays.ArrayGen;
import java.util.Arrays;

public class Merge {

    public static void sort(int[] arr){
        sortArray(arr,0,arr.length-1);
    }

    private static void sortArray(int[] arr, int l, int r) {

        if (l < r) {

            int mid = l + (r - l) / 2;

            sortArray(arr, l, mid);
            sortArray(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }

    }

    private static void merge(int[] arr, int l, int mid, int r) {

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

    public static void main(String[] args) {
        
        int[] x = ArrayGen.generateArray(5, 20, false);

        System.out.println("Generated Array: " + Arrays.toString(x));

        sort(x);

        System.out.println("Final Array: " + Arrays.toString(x));

    }
}
