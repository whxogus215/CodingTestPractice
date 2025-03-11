import java.util.*;

public class Main {
    
    public static int N, M;
    public static int[] sequence;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        sequence = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            sequence[i] = sc.nextInt();
        }
        
        int maxSum = 0;
        for(int start = 1; start <= N; start++) {
            int startIndex = start;
            int sum = 0;
            for(int i = 1; i <= M; i++) {
                sum += sequence[startIndex];
                startIndex = sequence[startIndex];
            }
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);
    }
}