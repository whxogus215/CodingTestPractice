import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int K = sc.nextInt();

        List<Edge>[] edges = new ArrayList[V + 1];
        for(int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges[u].add(new Edge(v, w));
        }

        int[] cost = new int[V + 1];
        int[] visited = new int[V + 1];
        
        Arrays.fill(cost, INF);
        cost[K] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.weight, e2.weight));
        queue.add(new Edge(K, 0));
        
        while(!queue.isEmpty()) {
            Edge e = queue.poll();
            int start = e.end;

            if (visited[start] == 1) {
                continue;
            }
            visited[start] = 1;
            
            for(Edge edge : edges[start]) {
                if (cost[edge.end] > cost[start] + edge.weight) {
                    cost[edge.end] = cost[start] + edge.weight;
                    queue.add(new Edge(edge.end, cost[edge.end]));
                }
            }
        }

        for(int i = 1; i <= V; i++) {
            if (cost[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(cost[i]);
            }
        }
    }

    static class Edge {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
