import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        printMinCommon(n, m);
    }

    public static void printMinCommon(int n, int m) {
        int gcd = 0;
        for(int i = 1; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                gcd = i;
            }
        }

        System.out.println(n * m / gcd);
    }
}