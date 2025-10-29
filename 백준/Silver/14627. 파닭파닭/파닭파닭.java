import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int C = sc.nextInt();

        int[] depa = new int[S];
        
        long sum = 0;
        int maxLength = -1;
        for(int i = 0; i < S; i++) {
            depa[i] = sc.nextInt();
            maxLength = Math.max(maxLength, depa[i]);
            sum += depa[i];
        }

        int left = 1;
        int right = maxLength;
        long cutLength = 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;

            long count = 0;
            for(int i = 0; i < S; i++) {
                count += depa[i] / mid;
            }

            if (count >= C) {
                cutLength = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        long ramenDepa = sum - (cutLength * C);
        System.out.println(ramenDepa);
    }
}
