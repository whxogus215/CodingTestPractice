import java.util.*;

public class Main {
    
    private static int[][] arr = new int[20][20];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int count = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= N - 3; j++) {
                count = Math.max(count, arr[i][j] + arr[i][j + 1] + arr[i][j + 2]);
            }
        }

        System.out.println(count);
    }
}