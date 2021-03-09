package Sort;

import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] data = new int[5];

        System.out.println("Enter 5 elements: ");

        for (int i = 0; i < 5; i++) {
            data[i] = sc.nextInt();
        }

        System.out.println("\nBefore Sorting: ");

        for (int dat : data) {
            System.out.print("\t " + dat);
        }

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[i]) {
                    int temp = data[j];
                    data[j] = data[i];
                    data[i] = temp;
                }
            }
        }

        System.out.println("\n\n------------");

        System.out.println("\nAfter Sorting: ");

        for (int dat : data) {
            System.out.print("\t " + dat);
        }

        sc.close();

    }
}