package Backjoon.binarySearch;

import java.util.Scanner;
// https://kosaf04pyh.tistory.com/95
// https://st-lab.tistory.com/270

public class No2805 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int N = stdIn.nextInt();
        int M = stdIn.nextInt();
        int[] tree = new int[N];
        int max = 0; // 나무 최대 길이
        for (int i = 0; i < N; i++) {
            tree[i] = stdIn.nextInt();
            if(tree[i] > max) max = tree[i];
        }
        while(max >= 0){
            int sum = 0; // 가져갈 수 있는 나무의 총 길이(출력 값)
            for (int i = 0; i < N ; i++) {
                if ((tree[i] - max) > 0) { // 잘랐을 때, 가져갈 부분이 있는 경우
                    sum += (tree[i] - max);
                }
                if (sum == M) { // 원하는 길이를 얻었을 때
                    break;
                }
            }
            max--;
        }
        System.out.println(max);
    }
}
