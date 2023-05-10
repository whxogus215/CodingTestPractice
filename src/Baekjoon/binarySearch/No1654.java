package Backjoon.binarySearch;

// https://st-lab.tistory.com/269

import java.util.Scanner;

public class No1654 {
    static int[] arr;
    static int K;
    static int N;
    static int max;
    public static void main(String[] args) {
        input();
        /*
        결정 문제로 바꾸기 : 중간 값을 기준으로 판단했을 때, 랜선의 길이가 N개 나오는가?
         */
        int lo = 0;
        int hi = max;
        int mid = 1;
        // 중간 값 찾기 - 이진 탐색
        while (lo <= hi) {
            int lanNum = 0;
            mid = (lo + hi) / 2;
            // yes or no 판단 : mid 길이만큼 랜선을 짤랐을 때, 랜선이 N개 나오는지
            for (int i = 0; i < K; i++) {
                if (arr[i]/mid > 0) {
                    lanNum++;
                }
            }
            // 랜선이 N개 만큼 나왔더라도, 이것이 랜선의 최대 값이 아닐 수 있음. 따라서 최대 값인지 더 판단
            // mid 값을 더 높이면, 랜선은 최대 값이 될 수 있음. but, N 값은 보장 못함.
            if (lanNum >= N) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(mid);

    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        arr = new int[K];
        max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] > max) max = arr[i];
        }
    }
}
