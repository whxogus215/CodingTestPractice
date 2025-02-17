import java.util.*;

public class Main {

    public static int N;
    public static int[][] coordinate;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        coordinate = new int[N][2];

        for(int i = 0; i < N; i++) {
            coordinate[i][0] = sc.nextInt();
            coordinate[i][1] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int maxX = 0, maxY = 0;
            int minX = 40001, minY = 40001;
            for(int j = 0; j < N; j++) {
                if (j == i) {
                    continue;
                }
                maxX = Math.max(maxX, coordinate[j][0]);
                minX = Math.min(minX, coordinate[j][0]);

                maxY = Math.max(maxY, coordinate[j][1]);
                minY = Math.min(minY, coordinate[j][1]);
            }
            min = Math.min(min, (maxX - minX) * (maxY - minY));
        }

        System.out.println(min);
    }
}