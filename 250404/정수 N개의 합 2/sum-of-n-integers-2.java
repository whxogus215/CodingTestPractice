import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum[i + 1] = sum[i] + arr[i];
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i + k - 1 <= n; i++) {
            int curSum = sum[i + k - 1] - sum[i - 1];
            max = Math.max(max, curSum);
        }

        System.out.println(max);
    }
}