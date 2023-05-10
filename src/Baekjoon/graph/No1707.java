package Backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1707 {

    static ArrayList<Integer>[] list;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            list = new ArrayList[V + 1];
            check = new int[V + 1];
            visited = new boolean[V + 1];
            isEven = true;
            
            // 각 노드 별 ArrayList 초기화
            for (int j = 1; j <= V; j++) {
                list[j] = new ArrayList<Integer>();
            }
            // 인접 리스트에 엣지 연결하기
            for (int j = 0; j < E; j++) {
                input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                list[start].add(end);
                list[end].add(start);
            }
            // 각 노드별로 시작해서 DFS 시작 (끊어진 그래프가 있을 수 있으므로)
            for (int j = 1; j <= V; j++) {
                if (isEven) {
                    DFS(j);
                } else {
                    break;
                }
            }
            
            if (isEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void DFS(int start) {
        visited[start] = true;
        for (int adj : list[start]) {
            if (!visited[adj]) {
                check[adj] = (check[start] + 1) % 2;
                DFS(adj);
            } else if (check[start] == check[adj]) {
                isEven = false;
            }
        }

    }


}
