package Backjoon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 9; i++) {
            sb.append(N + " * " + i + " = " + N * i).append('\n');
        }
        System.out.println(sb);
    }
}
