import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static int leafCount = 0;
    private static int removeNode;
    private static boolean[] visited;
    private static List<Integer>[] tree;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        int rootNode = -1;
        for(int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            if (parent == -1) {
                rootNode = i;
                continue;
            }
            tree[parent].add(i);
        }

        // 입력받은 번호로 DFS -> 해당 구역을 방문하지 않는 상태로 변경(배열 사용)
        removeNode = sc.nextInt();
        if (removeNode == rootNode) {
            System.out.println(0);
        } else {
            dfs(rootNode);
            System.out.println(leafCount);
        }
    }

    private static void dfs(int startNode) {
        visited[startNode] = true;
        int childCount = 0;
        for(Integer node : tree[startNode]) {
            if (!visited[node] && node != removeNode) {
                childCount++;
                dfs(node);
            }
        }
        if (childCount == 0) {
            leafCount++;
        }
    }
}
