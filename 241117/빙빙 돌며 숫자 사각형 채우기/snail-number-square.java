import java.util.*;

// 우 -> 하 -> 좌 -> 상
public class Main {

    private static int[][] arr;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        arr[0][0] = 1;
        int x = 0;
        int y = 0;
        int dir = 0;

        for(int i = 2; i <= n * m; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!inRange(nx, ny) || arr[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            arr[nx][ny] = i;
            x = nx;
            y = ny;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean inRange(int nx, int ny) {
        return (nx >= 0 && nx < n && ny >= 0 && ny < m);
    }
}