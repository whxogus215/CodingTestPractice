import java.util.*;

public class Main {

    public static final int MAX_LEN = 1000000;
    public static int N, Q;
    public static int[] sum = new int[MAX_LEN + 1];
    public static int[] arr = new int[MAX_LEN + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); Q = sc.nextInt();

        while(N > 0) {
            int pos = sc.nextInt();
            arr[pos] = 1;
            N--;
        }

        for(int i = 0; i <= MAX_LEN; i++) {
            if (i == 0) {
                sum[i] = arr[i];
                continue;
            }
            sum[i] = sum[i - 1] + arr[i];
        }

        while(Q > 0) {
            int count = 0;
            int A = sc.nextInt();
            int B = sc.nextInt();

            count = sum[B] - sum[A] + arr[A];
            System.out.println(count);

            Q--;
        }
    }
}