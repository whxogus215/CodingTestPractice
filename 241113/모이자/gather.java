import java.util.*;

public class Main {
    
    private static int[] house = new int[101];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            house[i] = sc.nextInt();
        }

        int minDistance = Integer.MAX_VALUE;
        // 1번째 집으로 모이는 순간부터 n번째 집이 모이는 순간까지 전부 탐색한다 => 완전탐색
        for(int i = 1; i <= n; i++) {
            int distance = 0;
            for(int j = 1; j <= n; j++) {
                distance += house[j] * Math.abs(i - j);
            }
            minDistance = Math.min(minDistance, distance);
        }

        System.out.println(minDistance);
    }
}