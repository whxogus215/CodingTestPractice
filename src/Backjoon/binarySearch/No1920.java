package Backjoon.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class No1920 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int N = stdIn.nextInt();
        int[] arrN = new int[N];
        for (int i = 0; i < N; i++) {
            arrN[i] = stdIn.nextInt();
        }
        int M = stdIn.nextInt();
        int[] arrM = new int[M];
        for (int i = 0; i < M; i++) {
            arrM[i] = stdIn.nextInt();
        }

        int[] result = new int[M];

        Arrays.sort(arrN);

        for (int i = 0; i < M; i++) {
            int idx = Arrays.binarySearch(arrN, arrM[i]);
            if (idx >= 0) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        for (int idx : result) {
            System.out.println(idx);
        }
    }
}
