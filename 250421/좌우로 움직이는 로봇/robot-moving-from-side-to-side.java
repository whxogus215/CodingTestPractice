import java.util.*;

public class Main {
    
    public static final int OFFSET = 1000000;
    public static int[] A = new int[2 * OFFSET + 1];
    public static int[] B = new int[2 * OFFSET + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        A[0] = OFFSET; B[0] = OFFSET;

        int aTime = 0;
        for(int i = 0; i < N; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            while(t-- > 0) {
                aTime++;
                if (d == 'R') {
                    A[aTime] = A[aTime - 1] + 1;
                } else {
                    A[aTime] = A[aTime - 1] - 1;
                }
            }
        }

        int bTime = 0;
        for(int i = 0; i < M; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            while(t-- > 0) {
                bTime++;
                if (d == 'R') {
                    B[bTime] = B[bTime - 1] + 1;
                } else {
                    B[bTime] = B[bTime - 1] - 1;
                }
            }
        }

        int metCount = 0;
        boolean isBeforeMet = true;
        for(int i = 1; i <= Math.max(aTime, bTime); i++) {
            int aPos = 0;
            int bPos = 0;
            
            if (i > Math.min(aTime, bTime)) {
                if (Math.min(aTime, bTime) == aTime) {
                    aPos = A[aTime];
                    bPos = B[i];
                } else {
                    aPos = A[i];
                    bPos = B[bTime];
                }

            } else {
                aPos = A[i];
                bPos = B[i];
            }
            if (!isBeforeMet && aPos == bPos) {
                metCount++;
                isBeforeMet = true;
            }
            if (aPos != bPos) {
                isBeforeMet = false;
            }
        }
        System.out.println(metCount);
    }
}