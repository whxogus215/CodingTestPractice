package Backjoon.stackAndqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // String 타입, 개행 문자 기준으로 입력받음
        Stack<Integer> stack = new Stack<>();

        int sum = 0; // 출력할 정수 합계

        for (int i = 0; i < num; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                stack.pop();
            } else {
                stack.push(input);
            }
        }

        for (Integer integer : stack) {
            sum += integer;
        }

        System.out.println(sum);

    }
}
