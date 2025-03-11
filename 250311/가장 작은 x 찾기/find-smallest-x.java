import java.util.*;

public class Main {
    
    public static int N;
    public static int[] a;
    public static int[] b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        a = new int[N];
        b = new int[N];

        for(int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        int minX = Integer.MAX_VALUE;

        int start = a[0] / 2;
        int end = b[0] / 2;

        for(int i = start; i <= end; i++) {
            if (i < 1) {
                continue;
            }
            int value = i * 2;
            boolean isSatisfied = true;
            for(int j = 0; j < N; j++) {
                if (value < a[j] || value > b[j]) {
                    isSatisfied = false;
                }
                value *= 2;
            }
            if (isSatisfied) {
                minX = Math.min(minX, i);
            }
        }

        System.out.println(minX);
    }
}