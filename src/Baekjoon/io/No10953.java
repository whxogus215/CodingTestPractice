package Backjoon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String str;
        for (int i = 0; i < T; i++) {
            str = br.readLine();
            int A = str.charAt(0) - 48;
            int B = str.charAt(2) - 48;
            System.out.println(A + B);
        }
    }
}
