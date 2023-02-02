package Backjoon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            if(str.equals("0 0")){
                break;
            }
            int A = str.charAt(0) - '0';
            int B = str.charAt(2) - '0';
            System.out.println(A + B);
        }
    }
}
