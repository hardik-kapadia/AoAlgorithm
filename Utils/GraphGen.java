package Utils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GraphGen {

    public static void main(String[] args) {

        int[][] graph = getRandomGraph(5, 6);
        int[][] graph2 = generateCustomGraph();

        System.out.println("1:");
        printGraph(graph);

        System.out.println("\n2:");
        printGraph(graph2);
    }

    static void printGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }

    public static int[][] generateCustomGraph(int n) {

        Scanner scanner = new Scanner(System.in);

        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.out
                    .println("Enter connections for " + i + "[-1 to break, will overwrite, so don't mention double]: ");
            while (true) {
                System.out.print("Node: ");
                int node = scanner.nextInt();
                if (node == -1)
                    break;

                System.out.print("Length: ");
                int length = scanner.nextInt();

                if (node < 0 || node >= n || length < 0)
                    continue;

                graph[i][node] = length;
                graph[node][i] = length;
            }

        }
        scanner.close();
        return graph;
    }

    public static int[][] generateCustomGraph() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

        scanner.close();

        return generateCustomGraph(n);

    }

    public static int[][] getRandomGraph(int l, int max) {

        int[][] graph = new int[l][l];

        Random random = new Random();

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < i; j++) {

                if (i == j) {
                    graph[i][j] = 0;
                    graph[i][j] = 0;
                } else {
                    int temp = random.nextInt(max) + 1;
                    graph[j][i] = temp;
                    graph[i][j] = temp;
                }
            }
        }

        return graph;
    }
}
