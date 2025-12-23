import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Node root = new Node();
        for(int i = 0; i < N; i++) {
            char[] arr = sc.next().toCharArray();
            Node now = root;
            for(char c : arr) {
                int idx = c - 'a';
                if (now.next[idx] == null) {
                    now.next[idx] = new Node();
                }
                now = now.next[idx];
            }
        }

        int answer = 0;
        for(int i = 0; i < M; i++) {
            char[] arr = sc.next().toCharArray();
            Node now = root;
            boolean isPrefix = true;
            for(int j = 0; j < arr.length; j++) {
                int idx = arr[j] - 'a';
                if (now.next[idx] == null) {
                    isPrefix = false;
                    break;
                }
                now = now.next[idx];
            }
            if (isPrefix) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}

class Node {
    Node[] next = new Node[26];
}
