package Backjoon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N - i - 1; j++) {
                sb.append(" ");
            }
            for (int j = 1; j <= 2 * i + 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
