import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(getCount(n));        
    }

    public static int getCount(int n) {
        if (n == 1) {
            return 0;
        }

        if (n % 2 == 0) {
            return getCount(n / 2) + 1;
        } else {
            return getCount(3 * n + 1) + 1;
        }
    }
}