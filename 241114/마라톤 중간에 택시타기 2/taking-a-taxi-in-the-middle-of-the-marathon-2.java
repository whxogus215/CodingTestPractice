import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];

        for(int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int minDistance = Integer.MAX_VALUE;
        for(int i = 1; i < N - 1; i++) {
            minDistance = Math.min(minDistance, getDistance(x, y, i));
        }
        System.out.println(minDistance);
    }

    private static int getDistance(int[] x, int[] y, int index) {
        int beforeX = x[0];
        int beforeY = y[0];
        int distance = 0;
        for(int i = 1; i < x.length; i++) {
            if (i == index) {
                continue;
            }
            distance += Math.abs(x[i] - beforeX) + Math.abs(y[i] - beforeY);
            beforeX = x[i];
            beforeY = y[i];
        }
        return distance;
    }
}