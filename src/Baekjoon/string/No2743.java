package Backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuffer sb = new StringBuffer();
        sb.append(input.length());
        System.out.println(sb);

    }
}
