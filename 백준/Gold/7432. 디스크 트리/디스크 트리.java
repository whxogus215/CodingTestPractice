import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static int[][] tree;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node root = new Node();
        while(N-- > 0) {
            String line = sc.next();
            String[] directory = line.split("\\\\");
            Node now = root;
            for(String d : directory) {
                if (!now.next.containsKey(d)) {
                    now.next.put(d, new Node());
                }
                now = now.next.get(d);
            }
        }

        dfs(root, 0);
    }

    private static void dfs(Node node, int depth) {
        for(String key : node.next.keySet()) {
            for(int i = 1; i <= depth; i++) {
                System.out.print(" ");
            }
            System.out.println(key);
            dfs(node.next.get(key), depth + 1);
        }
    }
}

class Node {
    TreeMap<String, Node> next = new TreeMap<>();
}
