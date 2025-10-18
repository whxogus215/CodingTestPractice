import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        int low = 0;
        int high = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int sum = 0;
            int count = 0;
            for(int i = 0; i < N; i++) {
                if (arr[i] + sum > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if (sum != 0) {
                count++;
            }
            if (count > M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        System.out.println(low);
    }
}
