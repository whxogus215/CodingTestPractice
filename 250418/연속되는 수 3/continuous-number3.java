import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int signal = arr[0] > 0 ? 1 : -1;
        int length = 1;
        int max = length;

        for(int i = 1; i < n; i++) {
            if (signal * arr[i] > 0) {
                length++;
            } else {
                length = 1;
                signal = signal > 0 ? -1 : 1;
            }
            max = Math.max(max, length);
        }
        
        System.out.println(max);
    }
}