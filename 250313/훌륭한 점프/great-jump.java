import java.util.*;

public class Main {

    public static int MAX_N = 100;
    public static int N, K;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = MAX_N;
        for(int max = MAX_N; max >= Math.max(arr[0], arr[N - 1]); max--) {
            if(isPossible(max)) {
                result = Math.min(result, max);
            }
        }
        System.out.println(result);
    }

    public static boolean isPossible(int max) {
        int[] available = new int[N];
        int index = 0;
        for(int i = 0 ; i < N; i++) {
            if (arr[i] <= max) {
                available[index++] = i; 
            }
        }

        for(int i = 1; i < index; i++) {
            if (available[i] - available[i - 1] > K) {
                return false;
            }
        }
        return true;
    }
}