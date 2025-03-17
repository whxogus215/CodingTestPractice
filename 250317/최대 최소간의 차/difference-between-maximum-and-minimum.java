import java.util.*;

public class Main {

    public static int MAX = 10000;
    public static int N, K;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int minCost = Integer.MAX_VALUE;
        for(int i = 1; i + K <= MAX; i++) {
            int cost = 0;
            for(int j = 0; j < N; j++) {
                if (arr[j] < i) {
                    cost += Math.abs(arr[j] - i);
                } else if (arr[j] > i + K) {
                    cost += Math.abs(arr[j] - i - K);
                }
            }
            minCost = Math.min(minCost, cost);
        }
        System.out.println(minCost);
    }
}