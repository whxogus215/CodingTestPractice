import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        int index = 3;
        int x = 0;
        int y = 0;

        for(int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == 'L') {
                index = (index + 3) % 4;
            } else if (ch == 'R') {
                index = (index + 1) % 4;
            } else {
                x += dx[index];
                y += dy[index];
            }
        }

        System.out.println(x + " " + y);
    }
}