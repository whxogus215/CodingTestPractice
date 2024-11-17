import java.util.*;
// 벽에 부딪힌다 -> 배열 인덱스에서 벗어난다
// 이동하거나 혹은 방향을 바꿀 때마다 t를 1씩 감소시킨다
public class Main {
    
    private static int n;
    private static int t;
    
    private static int[][] arr;
    private static int[] dx = {0, -1, 1, 0};
    private static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();

        arr = new int[n][n];
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        char dir = sc.next().charAt(0);

        int index = getDir(dir);

        for(int i = 1 ; i <= t; i++) {
            int nx = x + dx[index];
            int ny = y + dy[index];
            if (!inRange(nx, ny)) {
                int newIndex = 3 - index;
                index = newIndex;
                continue;
            }
            x = nx;
            y = ny;
        }

        System.out.println((x + 1) + " " + (y + 1));
    }

    private static int getDir(char dir) {
        if (dir == 'R') {
            return 0;
        } else if (dir == 'U') {
            return 1;
        } else if (dir == 'D') {
            return 2;
        } else {
            return 3;
        }
    }

    private static boolean inRange(int nx, int ny) {
        return (nx >= 0 && nx < n && ny >= 0 && ny < n);
    }
}