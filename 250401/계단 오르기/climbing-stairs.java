import java.util.*;

public class Main {

    public static final int DIVIDE = 10007;
    public static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        int result = step(n);
        System.out.println(result);
    }

    public static int step(int n) {
        if (n < 0) {
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }

        if (n == 0) {
            memo[n] = 1;
        } else {
            memo[n] = (step(n - 3) + step(n - 2)) % DIVIDE;
        }

        return memo[n];
    }
}