package Backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No20004 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A;
        do {
            A = Integer.parseInt(br.readLine());
        } while (A > 31);

        for (int i = 1; i <= A; i++) {
            if(30 % (i + 1) == 0)
                sb.append(i).append("\n");
        }

        System.out.println(sb);

    }
}
