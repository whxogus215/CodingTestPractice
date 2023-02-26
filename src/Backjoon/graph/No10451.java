package Backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No10451 {
    static ArrayList<Integer>[] list;
    static int[] visited;
    static int count; // 순열 사이클 개수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 노드 개수
            list = new ArrayList[N + 1];
            visited = new int[N + 1]; // 방문배열 생성
            count = 0; // 카운트 초기화

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                list[j] = new ArrayList<>();
                list[j].add(Integer.parseInt(st.nextToken()));
            } // 인접 리스트 구현 완료

            for (int j = 1; j <= N; j++) { // visited 배열의 노드 1부터 N까지 탐색하면서 방문하지 않은 배열에 대해 DFS 탐색
              if(visited[j] != 1) {
                  DFS(list, j); // 방문하지 않았을 때만 DFS 탐색
                  count++;
              }
            }

            System.out.println(count);
        }
    }

    private static void DFS(ArrayList<Integer>[] list, int start) {
        if (visited[start] == 1) return ;
        visited[start] = 1;
        DFS(list, list[start].get(0));

    }
}
