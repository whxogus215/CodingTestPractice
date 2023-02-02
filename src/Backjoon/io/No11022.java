package Backjoon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 1; i <= T; i++) {
            sb.append("Case #").append(i).append(": ");
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            sb.append(A).append(" + ").append(B).append(" = ");
            sb.append(Integer.parseInt(A) + Integer.parseInt(B)).append("\n");
        }

        System.out.println(sb);
    }
}
