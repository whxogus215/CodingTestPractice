import java.util.*;

public class Main {

    private static final int DIR = 8;
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};

    private static int MAX_LENGTH = 50;
    private static int N;
    private static int M;
    private static int result;
    
    private static char[][] arr = new char[MAX_LENGTH][MAX_LENGTH];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for(int i = 0; i < N; i++) {
            String line = sc.next();
            for(int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    // 해당 위치에서 8방 탐색
                    for(int d = 0; d < DIR; d++) {
                        result += getLeeCount(i, j, d);
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static int getLeeCount(int y, int x, int d) {
        int count = 2;
        int cy = y;
        int cx = x;
        while(count > 0) {
            int ny = cy + dy[d];
            int nx = cx + dx[d];
            if (isNotRange(ny, nx) || arr[ny][nx] != 'E') {
                return 0;
            }
            cy = ny;
            cx = cx;
            count--;
        }
        return 1;
    }

    private static boolean isNotRange(int y, int x) {
        return y < 0 || y >= MAX_LENGTH || x < 0 || x >= MAX_LENGTH; 
    }
}