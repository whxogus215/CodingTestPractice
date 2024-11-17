import java.util.*;

public class Main {
    
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};    
    private static int[][] arr;
    private static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int threeCount = 0;
                for(int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (inRange(nx, ny) && arr[nx][ny] == 1) {
                        threeCount++;
                    }
                }
                if (threeCount >= 3) {
                        count++;
                }
            }
        }
        System.out.println(count);       
    }

    private static boolean inRange(int nx, int ny) {
        return (nx >= 0 && nx < n && ny >= 0 && ny < n);
    }
}