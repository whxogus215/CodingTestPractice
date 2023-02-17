package Backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11724 {

    static int[][] graph;
    static Queue<Integer> queue;
    static int count; // connected component 개수
    static int[] visited; // 방문한 정점 확인 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수

        graph = new int[N + 1][N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[first][second] = graph[second][first] = 1;
        }

        queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (visited[i] != 1) { // 방문하지 않은 정점에 대해서만 BFS 탐색
                BFS(graph, i);
                count++; // BFS 탐색이 다 끝나면 count 값 1 증가
            }
        }

        System.out.println(count);
    }

    private static void BFS(int[][] graph, int start) {
        if (visited[start] == 1) {
            return;
        }
        visited[start] = 1;
        for (int i = 1; i < graph.length; i++) {
            if (graph[start][i] == 1 && visited[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            BFS(graph, queue.remove());
        }
    }
}
