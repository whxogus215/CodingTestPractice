import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        if (isIntercet(a, b, c, d)) {
            int min = Math.min(a, Math.min(b, Math.min(c, d)));
            int max = Math.max(a, Math.max(b, Math.max(c, d)));
            System.out.println(max - min);
        } else {
            System.out.println((b - a) + (d - c));
        }
    }

    public static boolean isIntercet(int a, int b, int c, int d) {
        if (b < c || d < a) {
            return false;
        }
        return true;
    }
}