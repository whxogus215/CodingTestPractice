import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int count = findCount369(a, b);
        System.out.println(count);
    }

    public static int findCount369(int a, int b) {
        int count = 0;
        for(int i = a; i <= b; i++) {
            if (isContain369(i) || i % 3 == 0) {
                count++;
            }
        }
        return count;
    }

    public static boolean isContain369(int i) {
        while (i != 0) {
            if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                return true;
            }
            i /= 10;
        }
        return false;
    }
}