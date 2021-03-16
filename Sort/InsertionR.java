package Sort;

import java.util.Arrays;

import Utils.ArrayGen;

public class InsertionR {

    public static int sort(int[] arr, int index, int value) {
        if (index > 0 && arr[index - 1] > value) {

            arr[index] = arr[index - 1];
            index--;

            return sort(arr, index, value);
        } else
            return index;
    }

    public static void start(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int value = arr[i];
            int index = i;

            index = sort(arr, index, value);

            arr[index] = value;

        }

    }

    public static void main(String[] args) {

        int[] arr = ArrayGen.generateArray(10, 20, false);

        System.out.println("Before sorting (with recursion): " + Arrays.toString(arr));
        start(arr);
        System.out.println("After Sorting (with recursion): " + Arrays.toString(arr));

    }

}
