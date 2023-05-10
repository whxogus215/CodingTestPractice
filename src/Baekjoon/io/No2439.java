package Backjoon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i ; j++) {
                sb.append(" ");
            }
            for (int j = N - i + 1; j <= N ; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
