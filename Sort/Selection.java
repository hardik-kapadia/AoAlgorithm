package Sort;

import java.util.Arrays;

public class Selection {

    public static void main(String[] args) {
        int[] x = { 3, 7, 1, 6, 2, 4 };
        sort(x);
    }

    public static void sort(int[] arr) {

        int min, in;

        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            in = i;

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    in = j;
                }
            }

            if (in != i) {
                int temp = arr[i];
                arr[i] = arr[in];
                arr[in] = temp;
            }

        }
    }

}