package Backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No23968 {
    static void swap(int[] x, int a, int b) {
        if (x[a] > x[b]) {
            int temp = x[a];
            x[a] = x[b];
            x[b] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int Num = Integer.parseInt(input[0]); // 정렬하는 배열 요솟수
        int K = Integer.parseInt(input[1]); // 입력받은 교환 횟수
        int count = 0; // 실제로 진행된 교환 횟수

        int[] arr = new int[Num];
        String[] integer = br.readLine().split(" ");
        for (int i = 0; i < Num; i++) {
            arr[i] = Integer.parseInt(integer[i]);
        }

        int first,second = 0;
        loop:
        for (int i = Num - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1); // 왼쪽이 오른쪽보다 더 크면 교환
                    count++;
                }
                if (count == K) {
                    System.out.printf("%d %d\n", arr[j], arr[j+1]);
                    break loop;
                }
            }
        }

        if (count < K) {
            System.out.println("-1");
        }
    }
}
