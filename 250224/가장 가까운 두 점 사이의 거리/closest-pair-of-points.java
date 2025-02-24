import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // Please Write your code.
        // 가장 거리가 가까운 두 점을 구한다! N개 중 2개
        double minDistance = Double.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                double distanceX = Math.pow(x[i] - x[j], 2);
                double distanceY = Math.pow(y[i] - y[j], 2);
                minDistance = Math.min(minDistance, distanceX + distanceY);
            }
        }
        System.out.println((int) minDistance);
    }
}