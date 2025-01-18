import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            if (sum < 0 && sum < arr[i]) {
                sum = arr[i];
                continue;
            }
            sum += arr[i];
        }

        System.out.println(sum);
    }
}