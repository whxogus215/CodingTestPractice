import java.util.*;

public class Main {
    
    public static int MAX = 100_000;
    public static int n;
    public static int[] arr = new int[MAX];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int minPrice = arr[0];
        int profit = 0;
        for(int i = 0; i < n; i++) {
            if (arr[i] > minPrice) {
                profit = Math.max(profit, arr[i] - minPrice);
            } else {
                minPrice = arr[i];
            }
        }

        System.out.println(profit);
    }
}