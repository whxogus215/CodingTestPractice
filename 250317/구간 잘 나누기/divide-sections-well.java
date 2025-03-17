import java.util.*;

public class Main {

    public static int MAX = 10000;
    public static int MAX_N = 100;
    public static int N, M;

    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for(int min = 1; min <= MAX; min++) {
            boolean possible = true;
            int section = 1;
            int sum = 0;
            for(int i = 0; i < N; i++) {
                if (arr[i] > min) {
                    possible = false;
                    break;
                }
                if (sum + arr[i] > min) {
                    section++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if (possible && section <= M) {
                System.out.println(min);
                return;
            }
        }
    }
}