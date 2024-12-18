import java.util.*;

public class Main {

    private static int[] numbers = new int[100];
    private static int N;
    private static int S;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        for(int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                min = Math.min(min, Math.abs(S - getSumIgnore(numbers[i], numbers[j])));
            }
        }

        System.out.println(min);
    }

    private static int getSumIgnore(int first, int second) {
        int sum = 0;
        for(int i = 0; i < N; i++) {
            if (numbers[i] == first || numbers[i] == second) {
                continue;
            }
            sum += numbers[i];
        }

        return sum;
    }
}