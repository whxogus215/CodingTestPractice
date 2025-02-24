import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();
        int S = sc.nextInt();

        int[] sickLogs = new int[N + 1];
        int[][] eatLogs = new int[D][3];
        for(int i = 0; i < D; i++) {
            int p = sc.nextInt();
            int cheese = sc.nextInt();
            int eatTime = sc.nextInt();

            eatLogs[i] = new int[]{p, cheese, eatTime};
        }

        for(int i = 0; i < S; i++) {
            int p = sc.nextInt();
            int sickTime = sc.nextInt();
            sickLogs[p] = sickTime;
        }

        int maxSickPeople = 0;

        for(int i = 1; i < M; i++) {
            int max = 0;
            for(int j = 0; j < D; j++) {
                int person = eatLogs[j][0];
                int cheese = eatLogs[j][1];
                int eatTime = eatLogs[j][2];

                if (i != cheese) {
                    continue;
                }
                if (eatTime < sickLogs[person] || sickLogs[person] == 0) {
                    max++;
                }
            }
            maxSickPeople = Math.max(max, maxSickPeople);
        }

        System.out.println(maxSickPeople);
    }
}