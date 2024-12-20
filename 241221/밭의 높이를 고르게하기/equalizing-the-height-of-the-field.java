import java.util.*;

public class Main {

    private static final int MAX_N = 100;
    private static int[] heights = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();
        int T = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            heights[i] = sc.nextInt();
        }

        int minPrice = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            for(int j = T - 1; i + j <= Math.min(N, 10); j++) {
                if ((i + j) > MAX_N) {
                    continue;
                }
                int sum = 0;
                for(int k = i; k <= i + j; k++) {
                    sum += Math.abs(heights[k] - H);
                }
                minPrice = Math.min(sum, minPrice);
            }
        }
        System.out.println(minPrice);
    }
}