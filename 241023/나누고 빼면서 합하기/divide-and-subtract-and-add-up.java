import java.util.*;

public class Main {

    public static final int MAX_N = 100;
    public static int[] arr = new int[MAX_N];

    public static int n;
    public static int m;
    public static int sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(sum);
    }

    public static void sum() {
        while (m != 1) {
            sum += arr[m + 1];
            if (m % 2 == 0) {
                m /= 2;
            } else {
                m--;
            }
        }
    }
}