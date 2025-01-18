import java.util.*;

public class Main {

    public static int N;
    public static int a1, b1, c1, a2, b2, c2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a1 = sc.nextInt();
        b1 = sc.nextInt();
        c1 = sc.nextInt();

        a2 = sc.nextInt();
        b2 = sc.nextInt();
        c2 = sc.nextInt();
        
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= N; k++) {
                    if (isSatisfied(i, j, k)) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);        
    }

    public static boolean isSatisfied(int i, int j, int k) {
        if ((getAbs(a1, i) <= 2 || getAbs(a1, i) >= N - 2) && (getAbs(b1, j) <= 2 || getAbs(b1, j) >= N - 2) && (getAbs(c1, k) <= 2 || getAbs(c1, k) >= N - 2)) {
            return true;
        }
        if ((getAbs(a2, i) <= 2 || getAbs(a2, i) >= N - 2) && (getAbs(b2, j) <= 2 || getAbs(b2, j) >= N - 2) && (getAbs(c2, k) <= 2 || getAbs(c2, k) >= N - 2)) {
            return true;
        }
        return false;
    }

    public static int getAbs(int standard, int value) {
        return Math.abs(standard - value);
    }
}