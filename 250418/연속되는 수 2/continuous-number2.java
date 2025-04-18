import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                cnt++;
                max = cnt;
                continue;
            }
            if (a[i] != a[i - 1]) {
                max = Math.max(max, cnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }

        max = Math.max(max, cnt);
        System.out.println(max);
    }
}