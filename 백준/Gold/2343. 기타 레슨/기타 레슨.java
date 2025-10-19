import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        int min = 0;
        int max = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            min = Math.max(min, arr[i]);
            max += arr[i];
        }

        while(min <= max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            int sum = 0;
            for(int i = 0; i < arr.length; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if (sum != 0) {
                count++;
            }

            if (count <= M) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }
}
