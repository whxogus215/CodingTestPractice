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
        double max = arr[0];
        double sum = arr[0];
        
        for(int i = 1; i < N; i++) {
            if (arr[i] * sum < arr[i]) {
                sum = arr[i];
            } else {
                sum *= arr[i];
            }
            max = Math.max(max, sum);
        }
        
        System.out.printf("%.3f", max);
    }
}
