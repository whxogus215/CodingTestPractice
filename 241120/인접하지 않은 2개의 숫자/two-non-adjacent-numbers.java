import java.util.*;

public class Main {
    
    private static int n;
    private static int[] arr;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int standardIndex = i;
            int calcResult = calcMax(standardIndex);
            max = Math.max(max, calcResult);
        }

        System.out.println(max);
    }

    private static int calcMax(int standardIndex) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if (Math.abs(i - standardIndex) > 1) {
                max = Math.max(max, arr[standardIndex] + arr[i]);
            }
        }
        return max;
    }
}