import java.util.*;

public class Main {

    private static final int MAX_N = 100;
    private static int[] basket = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        for(int i = 0; i < N; i++) {
            int candy = sc.nextInt();
            int position = sc.nextInt();

            basket[position] += candy;
        }

        int max = 0;
        for(int i = 1; i <= MAX_N; i++) {
            int sum = 0;
            for(int j = i - K; j <= i + K; j++) {
                if (j < 1 || j > MAX_N) {
                    continue;
                }
                sum += basket[j];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}