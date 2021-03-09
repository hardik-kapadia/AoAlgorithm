package Main;

import Find.BinarySearch;
import Arrays.ArrayGen;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of elements: ");
        int len = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter limit: ");
        int max = Integer.parseInt(scanner.nextLine());

        int[] array = ArrayGen.generateArray(len, max,true);

        while (true) {
            System.out.print("Enter Element to be Searched [-1 to exit]: ");
            int x = Integer.parseInt(scanner.nextLine());
            if (x == -1)
                break;

            int index = BinarySearch.search(Arrays.copyOf(array, len), x);

            BinarySearch bs = new BinarySearch(array, x);
            int index1 = bs.index();

            if (index != -1) {
                System.out.println("Element found at: " + index);
            } else {
                System.out.println("Element not found");
            }

            if (index1 != -1) {
                System.out.println("Element found at: " + index1);
            } else {
                System.out.println("Element not found");
            }

        }

        scanner.close();
    }
    
}