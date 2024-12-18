import java.util.*;

public class Main {
    
    private static final int SIZE = 19;
    private static int[][] badook = new int[SIZE][SIZE];

    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    private static int dir = -1;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                badook[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if (badook[i][j] != 0) {
                    // 오목인지 확인
                    if (isOmok(i, j)) {
                        // 중앙 돌의 가로줄 세로줄 출력
                        int omokY = i + dy[dir] * 2;
                        int omokX = j + dx[dir] * 2;
                        System.out.println(badook[i][j]);
                        System.out.println((omokY + 1) + " " + (omokX + 1));
                        return ;
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static boolean isOmok(int y, int x) {
        int dol = badook[y][x];

        for(int i = 0 ; i < 8; i++) {
            int count = 4;
            int cy = y;
            int cx = x;
            while(count > 0) {
                // 한 방향으로 4번 탐색
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (badook[ny][nx] != dol) {
                    break;
                }
                cy = ny;
                cx = nx;
                count--;
            }
            if (count == 0) {
                dir = i;
                return true;
            }
        }
        return false;
    }
}