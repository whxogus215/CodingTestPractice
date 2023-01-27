package Backjoon.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class No10815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        /*
        1. binarySearch 함수 구현하기
         */
        StringBuilder sb = new StringBuilder();
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int key = sc.nextInt();
            sb.append(binarySearch(arr, key)).append(' ');
        }
        System.out.println(sb);
    }
    private static int binarySearch(int[] arr, int key) {
        int lo = 0; int hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (key > arr[mid]) {
                lo = mid + 1;
            } else if (key < arr[mid]) {
                hi = mid;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
