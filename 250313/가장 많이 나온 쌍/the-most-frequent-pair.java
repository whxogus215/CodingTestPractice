import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[M][2];
        for(int i = 0; i < M; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();

            int min = Math.min(first, second);
            int max = Math.max(first, second);

            arr[i][0] = min;
            arr[i][1] = max;
        }

        int maxCount = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = i + 1; j <= N; j++) {
                int count = 0;
                for(int k = 0; k < M; k++) {
                    if (arr[k][0] == i && arr[k][1] == j) {
                        count++;
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        System.out.println(maxCount);
    }
}