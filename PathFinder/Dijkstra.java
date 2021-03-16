package PathFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dijkstra {
    
    final int V;
    List<Integer>[] paths;
    int[] solution;
    int[][] graph;

    Dijkstra(int[][] graph) {
        this.graph = graph;
        this.V = graph.length;
        this.paths = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            this.paths[i] = new ArrayList<>();
        }
        this.solution = new int[V];
    }

    int minDistance(int dist[], Boolean sptSet[]) {

        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    public int getDistance(int j) {
        return solution[j];
    }

    void printSolution(int dist[]) {
        System.out.println("\n\nVertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i] + " through\t" + paths[i].toString());
    }

    void dijkstra(int src) {

        int dist[] = new int[V];

        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, sptSet);
            System.out.println("Processing: " + u);

            sptSet[u] = true;
            System.out.println("Processing Status: " + Arrays.toString(sptSet));

            for (int v = 0; v < V; v++)

                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    paths[v] = new ArrayList<>(paths[u]);
                    paths[v].add(u);
                }

            System.out.println("Dist: " + Arrays.toString(dist));
        }

        this.solution = dist;
        printSolution(dist);
    }

    public static void main(String[] args) {
        int graph1[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        int[][] graph2 = new int[][] { { 0, 3, 4, 0, 0, 2 }, { 3, 0, 4, 0, 1, 0 }, { 0, 4, 0, 2, 5, 0 },
                { 0, 0, 2, 0, 5, 0 }, { 0, 1, 5, 5, 0, 2 }, { 2, 0, 0, 0, 2, 0 } };

        Dijkstra g1 = new Dijkstra(graph1);
        g1.dijkstra(2);

        Dijkstra g2 = new Dijkstra(graph2);
        g2.dijkstra(0);

    }
}