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
        int[] videos = new int[N];
        for(int i = 0; i < N; i++) {
            videos[i] = sc.nextInt();
            low = Math.max(low, videos[i]);
            high += videos[i];
        }

        int result = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + (high - low) / 2; // 블루레이 크기

            int count = 0;
            int sum = 0;
            for(int i = 0; i < N; i++) {
                if (sum + videos[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += videos[i];
            }

            if (sum > 0) {
                count++;
            }

            if (count <= M) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }
}
