import java.util.*;

public class Main {

    public static int N, M;
    public static int totalSum;
    public static int max = Integer.MAX_VALUE;
    public static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
            totalSum += numbers[i];
        }

        for(int i = 0; i < N; i++) {
            int nowMax = 0;
            int total = 0;
            int cnt = 0;
            go(i, nowMax, total, cnt);
        }

        System.out.println(max);
    }

    public static void go(int index, int nowMax, int total, int cnt) {
        if (cnt == (M - 1)) {
            max = Math.min(nowMax, totalSum - total);
            return ;
        }
        if (cnt < (M- 1) && index >= N - 1) {
            return ;
        }
        for(int i = index + 1; i < N; i++) {
            int nowSum = 0;
            for(int j = index; j <= i; j++) {
                nowSum += numbers[j];
            }
            go(i + 1, Math.max(nowMax, nowSum), total + nowSum, cnt + 1);
        }
    }
}