package Backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1260 {
    static int[] visitedD; // DFS 탐색여부 확인 배열 생성
    static int[] visitedB; // BFS 탐색여부 확인 배열 생성
    static ArrayList<Integer> queue = new ArrayList<>(); // BFS Queue 생성

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수(양방향)
        int V = Integer.parseInt(st.nextToken()); // 시작 정점

        int[][] graph = new int[N+1][N+1]; // 그래프 생성
        visitedD = new int[N+1];
        visitedB = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[first][second] = 1;
            graph[second][first] = 1;
        }

        DFS(graph, V, N);
        System.out.println();
        BFS(graph, V, N);

    }

    private static void DFS(int[][] graph, int start, int N) {
        visitedD[start] = 1;
        System.out.print(start + " ");
        for (int i = 1; i <= N; i++) {
            if(graph[start][i] == 1 && visitedD[i] != 1){ // start 정점과 연결된 정점이 있을 경우 + 방문하지 않은 경우 : 번호가 작은 것부터 방문
                DFS(graph, i, N);
            }
        }
    }

    private static void BFS(int[][] graph, int start, int N) {

        visitedB[start] = 1;
        System.out.print(start + " ");
        for (int i = 1; i <= N; i++) {
            if(graph[start][i] == 1 && visitedB[i] != 1){ // start 정점과 연결된 정점이 있을 경우 + 방문하지 않은 경우 : 번호가 작은 것부터 방문
                queue.add(i);
                visitedB[i] = 1;
            }
        }
        while(!queue.isEmpty()){
            BFS(graph, queue.remove(0), N); // queue에서 맨앞 값을 꺼내서 BFS 탐색
        }
    }
}
