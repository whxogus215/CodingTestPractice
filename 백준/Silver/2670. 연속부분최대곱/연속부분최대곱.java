import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        double[] arr = new double[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextDouble();
        }

        double cur = arr[0];
        double max = cur;

        for(int i = 1; i < arr.length; i++) {
            if (cur > 1) {
                cur *= arr[i];
            } else {
                cur = arr[i];
            }
            max = Math.max(max, cur);
        }
        
        System.out.printf("%.3f", max);
    }
}
