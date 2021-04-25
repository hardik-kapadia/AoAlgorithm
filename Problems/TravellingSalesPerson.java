package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Math.MinMax;
import Utils.GraphGen;
import Utils.MyArray;

public class TravellingSalesPerson {

    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {

        // int[][] graph = { { 0, 10, 15, 20 }, { 5, 0, 9, 10 }, { 6, 13, 0, 12 }, { 8, 8, 9, 0 } };
        int[][] graph1 = GraphGen.getWeightedRandomGraph(5, 25);

        GraphGen.printGraph(graph1);

        TravellingSalesPerson.Route sRoute = TravellingSalesPerson.getShortestRoute(graph1);
        System.out.println(sRoute);
    }

    public static Route getShortestRoute(int[][] graph) {

        int[] nodes = new int[graph.length];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = i;
        return shortestPath(0, graph, nodes);
    }

    public static int getShortestPathDistance(int[][] graph) {

        int[] nodes = new int[graph.length];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = i;
        return shortestPathDistance(0, graph, nodes);
    }

    private static int shortestPathDistance(int src, int[][] graph, int[] nodes) {

        System.out.println("\nSrc: " + src + "\tnodes: " + Arrays.toString(nodes));

        if (nodes.length == 1) {
            System.out.println("From " + src + " to " + nodes[0] + " : " + graph[src][nodes[0]]);
            return graph[src][nodes[0]];
        }

        int[] routes = new int[nodes.length - 1];

        int count = 0;

        for (int i = 1; i < nodes.length; i++) {

            if (nodes[i] == src)
                continue;

            routes[count] = graph[src][nodes[i]]
                    + shortestPathDistance(nodes[i], graph, MyArray.getRemovedArray(nodes, nodes[i]));
            count++;

        }

        System.out.println(src + ". " + Arrays.toString(routes));

        return MinMax.getMin(routes);
    }

    private static Route shortestPath(int src, int[][] graph, int[] nodes) {

        System.out.println("\nSrc: " + src + "\tnodes: " + Arrays.toString(nodes));

        if (nodes.length == 1) {
            System.out.println("From " + src + " to " + nodes[0] + " : " + graph[src][nodes[0]]);
            return new Route(graph[src][nodes[0]], new ArrayList<Integer>(nodes[0]));
        }

        int[] routes = new int[nodes.length - 1];
        Route[] r = new Route[nodes.length - 1];

        int count = 0;

        for (int i = 1; i < nodes.length; i++) {

            if (nodes[i] == src)
                continue;

            Route temp = shortestPath(nodes[i], graph, MyArray.getRemovedArray(nodes, nodes[i]));
            temp.addNode(graph[src][nodes[i]], nodes[i]);

            r[count] = temp;

            routes[count] = graph[src][nodes[i]];
            count++;

        }

        System.out.println(src + ". " + Arrays.toString(routes));

        return getMinRoute(r);
    }

    private static Route getMinRoute(Route[] routes) {

        Route min = new Route(Integer.MAX_VALUE);

        for (Route r : routes)

            if (r.getDist() < min.getDist())
                min = r;

        return min;

    }

    public static class Route {

        private List<Integer> path;
        private int dist;

        public Route(int dist) {
            this.dist = dist;
            this.path = new ArrayList<>();
        }

        public Route(int dist, List<Integer> path) {
            this.path = path;
            this.dist = dist;
        }

        public List<Integer> getPath() {
            return path;
        }

        public int getDist() {
            return dist;
        }

        public void addNode(int dist, int node) {
            this.dist += dist;
            path.add(0, node);
        }

        @Override
        public String toString() {
            return this.dist + " through " + path;
        }

    }

}
