import java.util.*;

public class Main {
    
    public static int N;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            arr[i] *= 2;

            for(int j = 0; j < N; j++) {
                int[] newArr = new int[N - 1];
                int idx = 0;
                for(int k = 0; k < N; k++) {
                    if (k == j) {
                        continue;
                    }
                    newArr[idx++] = arr[k];
                }
                int sumDiff = 0;
                for(int k = 0; k < N - 2; k++) {
                    sumDiff += Math.abs(newArr[k + 1] - newArr[k]);
                }
                minDiff = Math.min(minDiff, sumDiff);
            }

            arr[i] /= 2;
        }

        System.out.println(minDiff);        
    }
}