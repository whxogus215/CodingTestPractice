import java.util.*;

public class Main {

    public static final int MAX_T = 1000000;
    public static final int[] A = new int[MAX_T + 1];
    public static final int[] B = new int[MAX_T + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int timeA = 0;
        for(int i = 0; i < N; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            while(t-- > 0) {
                timeA++;
                A[timeA] = A[timeA - 1] + v;
            }
        }

        int timeB = 0;
        for(int i = 0; i < M; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            while(t-- > 0) {
                timeB++;
                B[timeB] = B[timeB - 1] + v;
            }
        }

        char first = ' ';
        char now = ' ';
        int count = -1;
        for(int i = 1; i <= timeA; i++) {
            if (A[i] > B[i]) {
                now = 'A';
            } else if (B[i] > A[i]) {
                now = 'B';
            }

            if (now != first) {
                first = now;
                count++;
            }
        }

        System.out.println(count);
    }
}