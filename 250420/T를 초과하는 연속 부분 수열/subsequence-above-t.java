import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int max = 0;
        int length = 0;
        if (arr[0] > t) {
            length = 1;
        }

        for(int i = 1; i < arr.length; i++) {
            if (arr[i] > t) {
                length++;
            } else {
                length = 0;
            }
            max = Math.max(max, length);
        }

        System.out.println(max);
    }
}