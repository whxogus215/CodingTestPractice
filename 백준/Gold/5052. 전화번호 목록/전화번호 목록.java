import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            Node root = new Node();
            boolean isCorrect = true;
            for(int i = 0; i < n; i++) {
                char[] line = sc.next().toCharArray();
                Node now = root;
                for(char c : line) {
                    int idx = c - '0';
                    if (now.next[idx] != null && now.next[idx].isEnd) {
                        isCorrect = false;
                        break;
                    }
                    if (now.next[idx] == null) {
                        now.next[idx] = new Node();
                    }
                    now = now.next[idx];
                }
                now.isEnd = true;

                for(int j = 0; j < 10; j++) {
                    if (now.next[j] != null) {
                        isCorrect = false;
                        break;
                    }
                }
            }
            if (isCorrect) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

class Node {
    Node[] next = new Node[10];
    boolean isEnd;
}
