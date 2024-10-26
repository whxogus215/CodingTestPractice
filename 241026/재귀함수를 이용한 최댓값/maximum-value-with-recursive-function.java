import java.util.*;

public class Main {
    
    public static final int MAX_N = 100;
    public static int[] arr = new int[MAX_N];
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(arr[0]);
        }
        System.out.println(maxiest(arr[0], 1));
    }

    public static int maxiest(int max, int index) {
        if (index >= n) {
            return max;
        }
        max = Math.max(max, arr[index]);
        return maxiest(max, index + 1);
    }
}