package Backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No24060 {
    static int count = 0;
    static int result = -1;
    private static void mergeSort(int[] arr, int K) {
        int[] temp = new int[arr.length];
        mergeSort(K, arr,temp, 0, arr.length - 1);
    }

    private static void mergeSort(int K, int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(K, arr,temp, start, mid);
            mergeSort(K, arr,temp, mid + 1, end);
            merge(K,arr,temp, start, mid, end);
        }
    }

    private static void merge(int K, int[] arr, int[] temp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        // 각각의 영역 첫 번째 인덱스
        int part1 = start;
        int part2 = mid + 1;
        int idx = start;
        while (part1 <= mid && part2 <= end) {
            if(temp[part1] < temp[part2]){
                arr[idx++] = temp[part1++];
                count++;
            } else {
                arr[idx++] = temp[part2++];
                count++;
            }
            if (count == K) result = arr[idx - 1];
        }
        while (part1 <= mid) {
            arr[idx++] = temp[part1++];
            count++;
            if (count == K) result = arr[idx - 1];
        }
        while (part2 <= end) {
            arr[idx++] = temp[part2++];
            count++;
            if (count == K) result = arr[idx - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, K);

        System.out.println(result);
    }
}
