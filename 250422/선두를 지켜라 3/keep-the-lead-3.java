import java.util.*;

public class Main {

    public static final int MAX_TIME = 1000000;
    public static int[] A = new int[MAX_TIME + 1];
    public static int[] B = new int[MAX_TIME + 1];

    public static int[] whoIsFirst = new int[MAX_TIME + 1];
    public static final int A_FIRST = 1;
    public static final int B_FIRST = 2;
    public static final int A_B_FIRST = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int aTime = 0;
        for(int i = 0; i < N; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            while(t-- > 0) {
                aTime++;
                A[aTime] = A[aTime - 1] + v;
            }
        }

        int bTime = 0;
        for(int i = 0; i < M; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            while(t-- > 0) {
                bTime++;
                B[bTime] = B[bTime - 1] + v;
            }
        }

        int count = 0;
        for(int i = 1; i <= aTime; i++) {
            if (A[i] > B[i]) {
                whoIsFirst[i] = A_FIRST;
            } else if (A[i] < B[i]) {
                whoIsFirst[i] = B_FIRST;
            } else {
                whoIsFirst[i] = A_B_FIRST;
            }

            if (whoIsFirst[i] != whoIsFirst[i - 1]) {
                count++;
            }
        }

        System.out.println(count);
    }
}