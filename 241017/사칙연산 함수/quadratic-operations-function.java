import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String o = sc.next();
        int c = sc.nextInt();

        if (!isRightOperator(o)) {
            System.out.println("False");
        } else {
            System.out.println(a + " " + o + " " + c + " = " + getResult(a, o, c));
        }
    }

    public static boolean isRightOperator(String o) {
        if (o.equals("+") || o.equals("-") || o.equals("/") || o.equals("*")) {
            return true;
        }
        return false;
    }

    public static int getResult(int a, String o, int c) {
        if (o.equals("+")) {
            return plus(a, c);
        } else if (o.equals("-")) {
            return minus(a, c);
        } else if (o.equals("*")) {
            return multiple(a, c);
        } else {
            return div(a, c);
        }
    }

    public static int plus(int a, int c) {
        return a + c;
    }

    public static int minus(int a, int c) {
        return a - c;
    }

    public static int multiple(int a, int c) {
        return a * c;
    }

    public static int div(int a, int c) {
        return a / c;
    }
}