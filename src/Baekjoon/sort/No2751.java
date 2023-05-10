package Backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퀵 정렬 사용하기 O(N*logN)
public class No2751 {
    static void quickSort(int[] arr, int N) {
        int start = 0;
        int end = N - 1;
        quickSort(arr, start, end);
    }

    static void quickSort(int[] arr, int start, int end) {
        int part = partition(arr, start, end); // 퀵 정렬 시작 위치

        // 왼쪽 파티션에 요소가 최소 2개 이상일 때만 정렬
        if (start < part - 1) quickSort(arr, start, part - 1);
        // 오른쪽 파티션에 요소가 최소 2개 이상일 때만 정렬
        if (part < end) quickSort(arr, part, end);
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end) {
                swap(arr, start++, end--);
            }
        }
        return start;
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열 개수
        int K = Integer.parseInt(st.nextToken()); // 출력할 요소 인덱스
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, N);
        System.out.println(arr[K - 1]);
    }
}
