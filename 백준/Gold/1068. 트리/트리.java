import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static List<Integer>[] tree;
    public static boolean[] visited;
    public static int answer = 0;
    public static int removeNode;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        int root = -1;
        for(int i = 0; i < N; i++) {
            int node = sc.nextInt();
            if (node == -1) {
                root = i;
                continue;
            }
            tree[node].add(i);
        }
        removeNode = sc.nextInt();

        if (removeNode == root) {
            System.out.println(0);
            return ;
        }
        dfs(root);
        System.out.println(answer);
    }

    public static void dfs(int node) {
        visited[node] = true;
        int childCount = 0;
        for(int child : tree[node]) {
            if (!visited[child] && child != removeNode) {
                dfs(child);
                childCount++;
            }
        }
        if (childCount == 0) {
            answer++;
        }
    }
}
