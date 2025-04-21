import java.util.*;

public class Main {

    public static final int MAX_TIME = 250;
    public static final int INSPECT = 1;
    public static final int IMMUNE = 0;

    public static int N, T, K, P;
    public static int[] inspection;
    public static int[] count;

    public static int[] time1 = new int[MAX_TIME + 1];
    public static int[] time2 = new int[MAX_TIME + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        P = sc.nextInt();
        T = sc.nextInt();

        inspection = new int[N + 1]; inspection[P] = INSPECT;
        count = new int[N + 1]; count[P] = K;

        for(int i = 0; i < T; i++) {
            int time = sc.nextInt();
            int first = sc.nextInt();
            int second = sc.nextInt();

            time1[time] = first;
            time2[time] = second;
        }

        for(int t = 1; t <= MAX_TIME; t++) {
            if (time1[t] == 0) {
                continue;
            }
            int first = time1[t];
            int second = time2[t];

            if (inspection[first] == IMMUNE && inspection[second] == IMMUNE) {
                continue;
            }
            if (inspection[first] == INSPECT || inspection[second] == INSPECT) {
                if (inspection[first] == INSPECT && inspection[second] == IMMUNE) {
                    if (count[first] > 0) {
                        inspection[second] = INSPECT;
                        count[second] = K;
                        count[first]--;
                    }
                } else if (inspection[first] == IMMUNE && inspection[second] == INSPECT) {
                    if (count[second] > 0) {
                        inspection[first] = INSPECT;
                        count[first] = K;
                        count[second]--;
                    }
                } else {
                    count[first]--;
                    count[second]--;
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            System.out.print(inspection[i]);
        }
    }
}