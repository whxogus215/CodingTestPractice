import java.util.*;

public class Main {

    public static int MAX_N = 1000000;
    public static int N, K;
    public static int[] bombs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        bombs = new int[N];
        for(int i = 0; i < N; i++) {
            bombs[i] = sc.nextInt();
        }

        int maxBombNum = 0;
        int maxCount = 0;

        boolean[] exploded = new boolean[N];
        int[] explodeNum = new int[MAX_N + 1];

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if (j - i > K || bombs[i] != bombs[j]) {
                    continue;
                }

                if (exploded[i] == false) {
                    explodeNum[bombs[i]] += 1;
                    exploded[i] = true;
                }

                if (exploded[j] == false) {
                    explodeNum[bombs[j]] += 1;
                    exploded[j] = true;
                }
            }
        }

        for(int i = 0; i <= MAX_N; i++) {
            if (explodeNum[i] > 0 && explodeNum[i] >= maxCount) {
                maxCount = explodeNum[i];
                maxBombNum = i;
            }
        }

        System.out.println(maxBombNum);
    }
}