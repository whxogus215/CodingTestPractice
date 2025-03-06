import java.util.*;

public class Main {
    
    public static int MAX_T = 10000;
    public static int N;
    public static int[] times = new int[MAX_T + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();

            if (score > times[time]) {
                times[time] = score;
            }
        }

        int totalScore = 0;
        for(int i = 1; i <= MAX_T; i++) {
            totalScore += times[i];
        }
        System.out.println(totalScore);
    }
}