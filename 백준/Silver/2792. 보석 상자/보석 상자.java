import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int low = 1;
        int high = 0;
        int result = Integer.MAX_VALUE;
        
        int[] jewels = new int[M];
        for(int i = 0; i < M; i++) {
            jewels[i] = sc.nextInt();
            high = Math.max(high, jewels[i]);
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int total = 0;
            for(int i = 0; i < jewels.length; i++) {
                total += jewels[i] / mid;
                if (jewels[i] % mid != 0) {
                    total++;
                }
            }

            if (total <= N) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }            
        }
        
        System.out.println(result);
    }
}
