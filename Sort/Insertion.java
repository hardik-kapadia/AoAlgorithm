package Sort;

import java.util.Arrays;

import Utils.ArrayGen;

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
        int[] arr = ArrayGen.generateArray(10, 20, false);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}