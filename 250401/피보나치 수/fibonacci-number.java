import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int result = fibo(n);
        System.out.println(result);
    }

    public static int fibo(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }

        if (n <= 2) {
            memo[n] = 1;
        } else {
            memo[n] = fibo(n - 1) + fibo(n - 2);
        }

        return memo[n];
    }
}