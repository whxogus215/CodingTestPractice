package Backjoon.recur;

import java.util.Scanner;

public class No2447 {
    static char[][] arr;

    static void star(int x, int y, int cnt) {
        if (cnt == 1) {
            arr[x][y] = '*';
            return;
        }
        int length = 4 * (cnt - 1) * + 1; // cnt에 따라 사각형 모서리가 달라짐
        // 본인 영역 별 찍기
        for (int i = x; i <= x + length; i++) {
            arr[x][i] = '*'; // 위쪽 모서리
            arr[i][y] = '*'; // 왼쪽 모서리
            arr[x + length][i] = '*'; // 아래쪽 모서리
            arr[i][y + length] = '*'; // 오른쪽 모서리
        }
        star(x + 2, y + 2, cnt - 1); // 안쪽 공백 별 채우기 (재귀 호출)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int len = 4 * N - 3;
        arr = new char[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[i][j] = ' ';
            }
        }
        star(0, 0, N);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
