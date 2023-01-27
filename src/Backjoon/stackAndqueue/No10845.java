package Backjoon.stackAndqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10845 {

    static class Queue {
        private int[] queue;
        private int max; // queue가 저장할 수 있는 최댓값
        private int num; // queue에 들어있는 개수

        public Queue(int max){
            this.max = max;
            queue = new int[max];
            this.num = 0;
        }

        public void push(int x) {
            queue[num++] = x;
        }

        public int empty(){
            return (num == 0) ? 1 : 0;
        }

        public int pop() {
            if (num <= 0) {
                return -1;
            }
            int output = queue[0];
            for (int i = 0; i < num - 1; i++) {
                queue[i] = queue[i+1];
            }
            num--;
            return output;
        }

        public int size() {
            return num;
        }

        public int front() {
            if (num <= 0) {
                return -1;
            }
            return queue[0];
        }

        public int back() {
            if (num <= 0) {
                return -1;
            }
            return queue[num - 1];
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Queue queue = new Queue(num);

        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                queue.push(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop")) {
                System.out.println(queue.pop());
            } else if (input[0].equals("size")) {
                System.out.println(queue.size());
            } else if (input[0].equals("empty")) {
                System.out.println(queue.empty());
            } else if (input[0].equals("front")) {
                System.out.println(queue.front());
            } else {
                System.out.println(queue.back());
            }
        }
    }
}
