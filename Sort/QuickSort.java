package Sort;

public class QuickSort {
    public static void main(String args[]) {
        int[] a = { 36, 2, 3, 20, 9, 13, 10, 11, 15, 7, 12 };
        
        for (int i : a)
            System.out.print(i + "  ");
        System.out.println();
        sort(a);
        for (int i : a)
            System.out.print(i + "  ");
    }

    public static void sort(int[] a) {

        int n = a.length;
        int low = 0;
        int high = n - 1;

        quickSort(a, low, high);

    }

    public static void quickSort(int a[], int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);

        }
    }

    public static int partition(int a[], int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (a[j] < pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        i++;
        int temp = a[i];
        a[i] = a[high];
        a[high] = temp;
        return (i);
    }
}