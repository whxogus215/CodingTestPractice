package Backjoon.stackAndqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Stack {
    List<Integer> stack = new ArrayList<>();
    int numOfStack = 0;
    public void push(int input){
        stack.add(input);
        numOfStack++;
    }

    public int pop() {
        if(stack.size() == 0)
            return -1;
        return stack.remove(--numOfStack);
    }

    public int size() {
        return stack.size();
    }

    public int empty() {
        if (stack.size() == 0)
            return 1;
        return 0;
    }

    public int top(){
        if (stack.size() == 0)
            return -1;
        return stack.get(numOfStack-1);
    }
}

public class No10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int orderNum = Integer.parseInt(br.readLine());

        Stack stack = new Stack();

        for (int i = 0; i < orderNum; i++) {
            // orderNum 만큼 반복하기 : 명령어 입력 받기
            String orderInput = br.readLine();
            String[] orders = orderInput.split(" ");
            // orders[0] : 명령어, orders[1] : push일 경우 입력 값
            String command = orders[0];
            if (command.equals("push"))
                stack.push(Integer.parseInt(orders[1]));
            else if (command.equals("pop"))
                sb.append(stack.pop()).append("\n");
            else if (command.equals("size"))
                sb.append(stack.size()).append("\n");
            else if (command.equals("empty"))
                sb.append(stack.empty()).append("\n");
            else
                sb.append(stack.top()).append("\n");
        }

        System.out.println(sb);
    }
}
