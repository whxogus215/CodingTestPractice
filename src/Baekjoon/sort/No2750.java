package Backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2750 {
    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 버블 정렬
        for (int i = 0; i < N - 1; i++) {
            for (int j = N - 1; j > i; j--) {
                if (arr[j-1] > arr[j]){
                    swap(arr, j, j - 1);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }


    }
}
