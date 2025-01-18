import java.util.*;

public class Main {
    
    private static int[] arr = new int[6];
    private static int sum;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                for(int k = j + 1; k < arr.length; k++) {
                    min = Math.min(min, getDiff(i, j, k));    
                }
            }
        }    
        System.out.println(min);
    }

    private static int getDiff(int i, int j, int k) {
        int sum1 = arr[i] + arr[j] + arr[k];
        int sum2 = sum - sum1;

        return Math.abs(sum2 - sum1);
    }
}