import java.util.*;

public class Main {
    
    public static final int MAX_N = 1000;
    public static int N;
    public static int[] arr = new int[MAX_N];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 0, N);

        System.out.println(groupMax());
    }

    public static int groupMax() {
        int max = -1;

        for(int i = 0; i < N - 1; i++) {
            int sum = arr[i] + arr[i + 1];
            max = Math.max(sum, max);
        }

        return max;
    }
}