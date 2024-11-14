import java.util.*;

public class Main {

    private static int[] arr = new int[1004];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        int minDistance = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j = 1; j <= N; j++) {
                if (j == i) {
                    continue;
                }
                if (i < j) {
                    sum += (j - i) * arr[j];
                } else {
                    sum += ((i - j) + (N - i)) * arr[j];
                }
            }
            minDistance = Math.min(minDistance, sum);
        }
        System.out.println(minDistance);
    }
}