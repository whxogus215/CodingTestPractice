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

        long left = 0;
        long right = 60_000_000_000L;
        long limit = 0;
        
        while(left <= right) {
            long mid = left + (right - left) / 2;

            long sum = M;
            for(int i = 0; i < M; i++) {
                sum += mid / time[i];
            }

            if (sum >= N) {
                limit = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        long totalSum = M;
        for(int i = 0; i < M; i++) {
            totalSum += (limit - 1) / time[i];
        }

        long lastPeople = totalSum;
        int lastNumber = 0;
        for(int i = 0; i < M; i++) {
            if (limit % time[i] == 0) {
                lastPeople++;
            }
            if (lastPeople == N) {
                lastNumber = i + 1;
                break;
            }
        }
        
        System.out.println(lastNumber);
    }
}
