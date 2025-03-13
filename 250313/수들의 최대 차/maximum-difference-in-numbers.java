import java.util.*;

public class Main {
    
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

        int maxCount = 0;
        for(int i = 0; i < N; i++) {
            int min = arr[i];
            int count = 0;
            for(int j = 0; j < N; j++) {
                if (j == i) {
                    continue;
                }
                if (Math.abs(min - arr[j]) <= K) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        System.out.println(maxCount);
    }
}