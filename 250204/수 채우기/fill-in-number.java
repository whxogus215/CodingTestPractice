import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 100_000;

        for (int i = 0; i <= 20000; i++) {
            int remainder = n - (5 * i);
            if (remainder >= 0 && remainder % 2 == 0) {
                result = Math.min(result, i + (remainder / 2));
            }
        }

        if (result == 100_000) {
            result = -1;
        }

        System.out.println(result);
    }
}