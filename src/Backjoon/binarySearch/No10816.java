package Backjoon.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class No10816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arrN = new int[N];
        for (int i = 0; i < N; i++) {
            arrN[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] arrM = new int[M];
        for (int i = 0; i < M; i++) {
            arrM[i] = sc.nextInt();
        }
        /*
        arrM의 요소를 하나의 Key로 가진 뒤, 정렬된 arrN에서 찾는다. (이분탐색 > 선형탐색)
        Key를 찾았을 때, count++; arrM[i] 의 값을 count로 변경/ count 초기 값 : 0
         */
        Arrays.sort(arrN);
        for (int i = 0; i < M; i++) {
            int count = 0;
            int lo = 0; int hi = N-1;
            // 이진탐색 : key = arrM[i]
            int key = arrM[i];
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (arrN[mid] > key) {
                    hi = mid - 1;
                } else if (arrN[mid] < key) {
                    lo = mid + 1;
                } else {
                    if (arrN[mid + 1] == key) {

                    }
                }
            }

        }

    }
}
