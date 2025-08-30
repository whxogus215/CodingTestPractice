import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static final long INF = Long.MAX_VALUE;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();

            edges.add(new Edge(start, end, weight));
        }

        long[] distance = new long[N + 1];
        Arrays.fill(distance, INF);
        distance[1] = 0;
        
        for(int i = 1; i <= N; i++) {
            for(Edge e : edges) {
                if (distance[e.start] == INF) {
                    continue;
                }
                if (distance[e.end] > distance[e.start] + e.weight) {
                    if (i == N) {
                        System.out.println(-1);
                        return ;
                    }
                    distance[e.end] = distance[e.start] + e.weight;
                }
            }
        }

        for(int i = 2; i <= N; i++) {
            long value = distance[i];
            if (value == INF) {
                value = -1;
            }
            System.out.println(value);
        }
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
