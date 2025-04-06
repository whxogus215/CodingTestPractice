import java.util.*;

public class Main {

    public static int N, K;
    public static int[] sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        sum = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            int element = sc.nextInt();
            sum[i] = sum[i - 1] + element;
        }
        
        int count = 0;
        for(int len = 1; len <= N - 1; len++) {
            for(int start = 1; start + len <= N; start++) {
                int rangeSum = sum[start + len] - sum[start - 1];
                if (rangeSum == K) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}