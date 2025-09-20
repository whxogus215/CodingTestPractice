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

        List<Node>[] nodes = new ArrayList[V + 1];
        boolean[] visited = new boolean[V + 1];
        int[] weights = new int[V + 1];
        Arrays.fill(weights, INF);
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.weight, n2.weight));
        
        for(int i = 1; i <= V; i++) {
            nodes[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            nodes[u].add(new Node(v, w));
        }
        queue.add(new Node(K, 0));
        weights[K] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int current = node.target;
            if (visited[current]) {
                continue;
            }
            visited[current] = true;
            for(Node n : nodes[current]) {
                if (weights[n.target] > weights[current] + n.weight) {
                    weights[n.target] = weights[current] + n.weight;
                    queue.add(new Node(n.target, weights[n.target]));
                }
            }
        }

        for(int i = 1; i <= V; i++) {
            if (weights[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(weights[i]);
            }
        }
    }

    static class Node {
        int target;
        int weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
}
