package Backjoon.recur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class No11729 {
    static StringBuilder sb = new StringBuilder();

    static void Hanoi(int N, int start, int mid, int to) {
        if (N == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        Hanoi(N - 1, start, to, mid);

        sb.append(start + " " + to + "\n");

        Hanoi(N - 1, mid, start, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        sb.append((int) (Math.pow(2, N) - 1)).append('\n');
        Hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }
}
