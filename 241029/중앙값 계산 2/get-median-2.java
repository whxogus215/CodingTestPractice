import java.util.*;

public class Main {

    public static final int MAX_N = 100;
    public static int n;
    public static int[] arr = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);

        for(int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.print(sortedArr[i/2 + 1] + " ");
            }
        }
    }
}