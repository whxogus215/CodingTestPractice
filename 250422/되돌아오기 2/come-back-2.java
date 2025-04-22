import java.util.*;

public class Main {

    public static final int DIR = 4;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] command = sc.next().toCharArray();
        int x = 0, y = 0, time = 0;
        int cDir = 3; // 북쪽
        for(int i = 0; i < command.length; i++) {
            char dir = command[i];

            if (dir == 'F') {
                x += dx[cDir];
                y += dy[cDir];
            }
            if (dir == 'R') {
                cDir = (cDir + 1) % DIR;
            }
            if (dir == 'L') {
                cDir = (cDir - 1 + 4) % DIR;
            }
            time++;
            if (x == 0 && y == 0) {
                break;
            }
        }

        if (x == 0 && y == 0) {
            System.out.println(time);
        } else {
            System.out.println(-1);
        }
    }
}