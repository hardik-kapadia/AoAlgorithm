package Sort;

import java.util.Arrays;

public class Insertion {
    public static void sort(int[] arr) {

        // System.out.println("Before sorting: " + Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {

            int value = arr[i];
            int index = i;
            while (index > 0 && arr[index - 1] > value) {
                arr[index] = arr[index - 1];
                index--;
            }

            arr[index] = value;

        }

        // System.out.println("After Sorting: " + Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 40, 25, 7, 13 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}