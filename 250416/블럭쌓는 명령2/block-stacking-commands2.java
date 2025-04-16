import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] blocks = new int[N + 1];

        int max = 0;
        for (int j = 0; j < K; j++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            for (int i = A; i <= B; i++) {
                blocks[i]++;
                max = Math.max(max, blocks[i]);
            }
        }

        System.out.println(max);
    }
}