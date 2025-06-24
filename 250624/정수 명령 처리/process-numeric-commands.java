import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        int n = sc.nextInt();

        while(n-- > 0) {
            String line = sc.next();
            if (line.startsWith("push")) {
                int number = sc.nextInt();
                s.push(number);
            }
            if (line.equals("size")) {
                System.out.println(s.size());
            }
            if (line.equals("pop")) {
                System.out.println(s.pop());
            }
            if (line.equals("empty")) {
                System.out.println(s.isEmpty() ? 1 : 0);
            }
            if (line.equals("top")) {
                System.out.println(s.peek());
            }
        }
    }
}