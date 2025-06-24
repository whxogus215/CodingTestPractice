import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Character> stack = new ArrayDeque<>();
        char[] tokens = sc.next().toCharArray();
        boolean flag = true;
        for(int i = 0; i < tokens.length; i++) {
            if (tokens[i] == '(') {
                stack.offerFirst(tokens[i]);
            } else {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                }
                stack.pollFirst();
            }
        }

        if (!stack.isEmpty()) {
            flag = false;
        }

        System.out.println(flag ? "Yes" : "No");
    }
}