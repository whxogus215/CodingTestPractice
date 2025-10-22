import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int low = 0;
        int high = 0;
        int[] prices = new int[N];
        for(int i = 0; i < N; i++) {
            prices[i] = sc.nextInt();
            low = Math.max(low, prices[i]);
            high += prices[i];
        }

        int minPrice = high;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            int count = 0;
            int remain = 0;
            for(int i = 0; i < N; i++) {
                int balance = prices[i];
                while(remain < balance) {
                    count++;
                    remain = mid;
                }
                remain -= balance;
            }

            if (count <= M) {
                minPrice = Math.min(minPrice, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(minPrice);
    }
}
