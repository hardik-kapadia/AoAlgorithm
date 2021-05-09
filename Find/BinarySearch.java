package Find;

import java.util.Arrays;

public class BinarySearch {

    int[] arr;
    int value;

    public BinarySearch(int[] arr, int value) {
        this.arr = arr;
        this.value = value;
    }

    public BinarySearch(int[] arr) {
        this.arr = arr;
        this.value = 0;
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

    private void setValue(int value) {
        this.value = value;
    }

    public int index(int value) {

        this.setValue(value);

        return index();
    }

    public static int search(int[] arr, int val) {

        int mid = (arr.length - 1) / 2;

        if (arr.length == 0)
            return -1;

        if (arr.length == 1)
            return arr[0] == val ? 0 : -1;

        if (arr[mid] == val)
            return mid;
        else if (arr[mid] < val) {
            int[] tempArr = Arrays.copyOfRange(arr, mid + 1, arr.length);
            int temp = search(tempArr, val);
            return temp == -1 ? -1 : temp + mid + 1;
        } else if (arr[mid] > val) {
            int[] tempArr = Arrays.copyOfRange(arr, 0, mid);
            return search(tempArr, val);
        }

        return -1;
    }

}