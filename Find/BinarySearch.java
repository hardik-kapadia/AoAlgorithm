package Find;

import java.util.Arrays;

public class BinarySearch {

    int[] arr;
    int value;

    public BinarySearch(int[] arr, int value) {
        this.arr = arr;
        this.value = value;
    }

    public int index() {

        int lb = 0, ub = arr.length - 1;
        int mid;

        while (lb <= ub) {
            mid = (lb + ub) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (value > arr[mid]) {
                lb = mid + 1;
            } else {
                ub = mid - 1;
            }
        }

        return -1;
    }

    public static int search(int[] arr, int val) {

        System.out.println("array rcvd: " + Arrays.toString(arr));

        int mid = (arr.length - 1) / 2;
        System.out.println("Mid is: " + mid);

        if (arr.length == 0)
            return -1;

        if (arr.length == 1)
            return arr[0] == val ? 0 : -1;

        if (arr[mid] == val)
            return mid;
        else if (arr[mid] < val) {
            int[] tempArr = Arrays.copyOfRange(arr, mid + 1, arr.length);
            System.out.println("Upper :" + Arrays.toString(tempArr));
            int temp = search(tempArr, val);
            return temp == -1 ? -1 : temp + mid + 1;
        } else if (arr[mid] > val) {
            int[] tempArr = Arrays.copyOfRange(arr, 0, mid);
            System.out.println("Lower " + Arrays.toString(tempArr));
            return search(tempArr, val);
        }

        return -1;
    }

}