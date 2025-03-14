import java.util.*;

public class Main {

    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] sum = new int[N - 1];

        for(int i = 0; i < N - 1; i++) {
            sum[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++) {
            int[] arr = new int[N];
            int[] isExist = new int[N + 1];
            
            arr[0] = i;
            isExist[i] = 1;

            boolean isComplete = true;
            for(int startIndex = 1; startIndex < N; startIndex++) {
                arr[startIndex] = sum[startIndex - 1] - arr[startIndex - 1];
                if (isExist[arr[startIndex]] == 1) {
                    isComplete = false;
                    break;
                } else {
                    isExist[arr[startIndex]] = 1;
                }
            }
            if (isComplete) {
                for(int k = 0; k < N; k++) {
                    System.out.print(arr[k] + " ");
                }
                return;
            }
        }

    }
}