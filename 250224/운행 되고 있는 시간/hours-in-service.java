import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }

        int max = -1;
        for(int i = 0; i < N; i++) {
            int[] times = new int[1001];
            for(int j = 0; j < N; j++) {
                if (j == i) {
                    continue;
                }
                for(int k = A[j]; k < B[j]; k++) {
                    times[k]++;
                }
            }
            int count = 0;
            for(int l = 1; l <= 1000; l++) {
                if (times[l] > 0) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}