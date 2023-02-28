package Backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1717 {
    static int[] array;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 집합 개수 n 개
        int m = Integer.parseInt(input[1]); // 연산 개수 m 개
        array = new int[n + 1]; // 0 부터 n까지 인덱스를 가져야 하기 때문에 n+1 크기의 배열로 생성
        for (int i = 0; i <= n; i++) {
            array[i] = i; // 맨 처음엔 대표 노드를 자신으로 지정 -> Union 연산 시 변경 됨.
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int findOrUnion = Integer.parseInt(input[0]); // 0이면 Union, 1이면 Find 연산 수행
            int first = Integer.parseInt(input[1]);
            int second = Integer.parseInt(input[2]);

            if (findOrUnion == 0) {
                // Union 함수
                functionUnion(first, second);
//                int firstPresent = functionFind(first);
//                int secondPresent = functionFind(second);
//                if (firstPresent <= secondPresent) array[secondPresent] = firstPresent;
//                else array[firstPresent] = secondPresent;
            } else {
                // Find 함수 + 출력
                if (functionFind(first) == functionFind(second)) {
//                    System.out.println("YES");
                    sb.append("YES").append("\n");
                } else {
//                    System.out.println("NO");
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.println(sb);
    }


    private static int functionFind(int node) {
        // node와 연결되어 있는 즉, 대표하는 값(최솟값) 찾기
        if (array[node] == node) return node;
        array[node] = functionFind(array[node]);
        return array[node];
    }

    private static void functionUnion(int first, int second){
        int firstPresent = functionFind(first);
        int secondPresent = functionFind(second);

        if (firstPresent <= secondPresent) array[secondPresent] = firstPresent;
        else array[firstPresent] = secondPresent;
    }
}
