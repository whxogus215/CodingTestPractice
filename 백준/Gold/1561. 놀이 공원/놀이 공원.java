import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] time = new int[M];
        for(int i = 0; i < M; i++) {
            time[i] = sc.nextInt();
        }

        if (N <= M) {
            System.out.println(N);
            return ;
        }
        
        long low = 1;
        long high = 60_000_000_000L;
        long limit = high + 1;
        while(low <= high) {
            long mid = low + (high - low) / 2;

            long sum = M;
            for(int i = 0; i < M; i++) {
                sum += mid / time[i];
            }

            if (sum >= N) {
                limit = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        long sum = M;
        for(int i = 0; i < M; i++) {
            sum += (limit - 1) / time[i];
        }

        for(int i = 0; i < M; i++) {
            if (limit % time[i] == 0) {
                sum++;
            }
            if (sum == N) {
                System.out.println(i + 1);
                return ;
            }
        }
    }
}
