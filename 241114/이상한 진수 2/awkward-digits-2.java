import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        int N = line.length();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[N-1-i] = line.charAt(i) - '0';
        }

        int max = Integer.MIN_VALUE;        
        for(int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) {
                arr[i] = 1;
            }
            max = Math.max(toBinarySum(arr), max);
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) {
                arr[i] = 1;
            }
        }
        System.out.println(max);
    }

    public static int toBinarySum(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i] * Math.pow(2, i);
        }
        return sum;
    }
}