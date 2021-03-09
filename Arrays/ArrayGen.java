package Arrays;

import java.util.Random;

import Sort.Insertion;

public class ArrayGen {

    public static int[] generateArray(int len, int max, boolean sorted) {
        int[] array = new int[len];
        Random random = new Random();

        for (int i = 0; i < len; i++) {
            int temp = random.nextInt(max);
            if (!contains(array, temp)) {
                array[i] = temp;
            } else {
                i--;
            }
        }
        if (sorted) {
            Insertion.sort(array);
        }

        return array;
    }

    static boolean contains(int[] arr, int val) {
        for (int i : arr) {
            if (i == val)
                return true;
        }
        return false;
    }

}