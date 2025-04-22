import java.util.*;

public class Main {

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int time = 0;
        int x = 0, y = 0;
        // N번 반복 후, 현재 위치가 (0, 0)인지 확인
        A:for(int i = 0; i < N; i++) {
            char c = sc.next().charAt(0);
            int d = sc.nextInt();

            int dir = getDir(c);
            while(d-- > 0) {
                x += dx[dir];
                y += dy[dir];
                time++;
                if (x == 0 && y == 0) {
                    break A;
                }
            }
        }
        if (x == 0 && y == 0) {
            System.out.println(time);
        } else {
            System.out.println(-1);
        }
    }

    public static int getDir(char d) {
        if (d == 'N') {
            return 3;
        } else if (d == 'E') {
            return 0;
        } else if (d == 'S') {
            return 1;
        } else {
            return 2;
        }
    }
}