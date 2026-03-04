import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] preSum = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            preSum[i] = arr[i] + preSum[i - 1];
        }

        for(int i = 1; i <= M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(preSum[end] - preSum[start - 1]);
        }
    }
}
