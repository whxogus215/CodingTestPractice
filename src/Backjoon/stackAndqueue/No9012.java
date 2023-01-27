package Backjoon.stackAndqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class No9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            System.out.println(stack(br.readLine()));
        }
    }

    // 입력받은 문자열을 판단하여 Yes or No를 출력하는 메서드
    private static String stack(String str) {
        int ptr = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '('){
                ptr += 1;
            } else { // ch == ')'
                if (ptr == 0) {
                    return "NO";
                }
                ptr -= 1;
            }
        }
        return (ptr == 0) ? "YES" : "NO";
    }
}
