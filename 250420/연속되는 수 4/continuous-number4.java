import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        int length = 0;
        for(int i = 0; i < arr.length; i++) {
            if (i >= 1 && arr[i] > arr[i - 1]) {
                length++;
            } else {
                length = 1;
            }
            max = Math.max(max, length);
        }

        System.out.println(max);
    }
}