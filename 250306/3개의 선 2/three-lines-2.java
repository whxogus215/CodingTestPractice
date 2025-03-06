import java.util.*;

public class Main {

    public static int N;

    public static int[] x;
    public static int[] y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        x = new int[N];
        y = new int[N];

        for(int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int result = 0;
        A:for(int i = 0; i <= 10; i++) {
            for(int j = 0; j <= 10; j++) {
                for(int k = 0; k <= 10; k++) {
                    boolean success = true;
                    for(int l = 0; l < N; l++) {
                        // y 축에 평행한 선분 3개일 때
                        if (x[l] == i || x[l] == j || x[l] == k) {
                            continue;
                        }
                        success = false;
                    }
                    if (success) {
                        result = 1;
                        break A;
                    }

                    success = true;
                    for(int l = 0; l < N; l++) {
                        // y축에 평행한 선분 1개, x축에 평행한 선분 2개
                        if (x[l] == i || y[l] == j || y[l] == k) {
                            continue;
                        }
                        success = false;
                    }
                    if (success) {
                        result = 1;
                        break A;
                    }

                    success = true;
                    for(int l = 0; l < N; l++) {
                        // y축에 평행한 선분 2개, x축에 평행한 선분 1개
                        if (x[l] == i || x[l] == j || y[l] == k) {
                            continue;
                        }
                        success = false;
                    }
                    if (success) {
                        result = 1;
                        break A;
                    }

                    success = true;
                    for(int l = 0; l < N; l++) {
                        // x축에 평행한 선분 3개
                        if (y[l] == i || y[l] == j || y[l] == k) {
                            continue;
                        }
                        success = false;
                    }
                    if (success) {
                        result = 1;
                        break A;
                    }
                }
            }
        }
        System.out.println(result);
    }
}