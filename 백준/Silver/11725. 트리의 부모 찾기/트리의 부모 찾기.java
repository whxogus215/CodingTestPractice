import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static boolean[] visited;
    private static List[] tree;
    
    public static void main(String[] args) {
        // 입력받은 값으로 트리를 구성한다. -> 인접행렬
        // 1번(루트)부터 시작해서 각 부모 노드를 방문하며 각 자식 노드의 인덱스에 부모노드 값을 추가한다.
        // 배열을 순회하면서 출력한다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        
        for(int i = 0; i < N - 1; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            if (tree[first] == null) {
                tree[first] = new ArrayList<>();
            }
            if (tree[second] == null) {
                tree[second] = new ArrayList<>();
            }
            tree[first].add(second);
            tree[second].add(first);
        }

        int[] parent = new int[N + 1];
        visited[1] = true;
        
        search(1, tree[1], parent);

        for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void search(int parent, List<Integer> childs, int[] arr) {
        for(int node : childs) {
            if (visited[node]) {
                continue;
            }
            arr[node] = parent;
            visited[node] = true;
            search(node, tree[node], arr);
        }
    }
}
