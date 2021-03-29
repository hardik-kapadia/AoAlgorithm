package Math;

public class MinMax {

    public static int getMin(int[] graph) {
        return min(graph, 0, graph.length - 1);
    }

    static int min(int[] graph, int start, int end) {
        int mid = (start + end) / 2;

        if (start > end) {
            System.out.println("Bruh");
            return Integer.MAX_VALUE;
        }
        if (start == end) {
            return graph[start];
        }
        if (start + 1 == end) {
            return graph[start] < graph[end] ? graph[start] : graph[end];
        }

        return Math.min(min(graph, start, mid), min(graph, mid + 1, end));

    }

    public static int getMax(int[] graph) {
        return max(graph, 0, graph.length - 1);
    }

    static int max(int[] graph, int start, int end) {
        int mid = (start + end) / 2;

        if (start > end) {
            System.out.println("Bruh");
            return Integer.MAX_VALUE;
        }
        if (start == end) {
            return graph[start];
        }
        if (start + 1 == end) {
            return graph[start] > graph[end] ? graph[start] : graph[end];
        }

        return Math.max(min(graph, start, mid), min(graph, mid + 1, end));

    }

}
