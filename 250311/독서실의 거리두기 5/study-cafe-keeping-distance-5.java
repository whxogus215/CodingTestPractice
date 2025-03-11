import java.util.*;

public class Main {

    public static int N;
    public static char[] chairs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        chairs = new char[N];
        String line = sc.next();
        chairs = line.toCharArray();

        int maxDistance = 0;
        for(int i = 0; i < N; i++) {
            if (chairs[i] == '1') {
                continue;
            }
            // 자리가 '0'일 때, (공석)
            chairs[i] = '1';

            int distance = Integer.MAX_VALUE;

            int preIndex = -1;
            for(int j = 0; j < N; j++) {
                if (chairs[j] == '1') {
                    if (preIndex != -1) {
                        distance = Math.min(distance, j - preIndex);
                    }
                    preIndex = j;
                }
            }

            maxDistance = Math.max(maxDistance, distance);
            // 복원
            chairs[i] = '0';
        }

        System.out.println(maxDistance);
    }
}