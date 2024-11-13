import java.util.*;

public class Main {

    private static char[][] map = new char[15][15];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                map[i][j] = sc.next().charAt(0);
            }
        }

        int count = 0;

        if (map[0][0] == map[R - 1][C - 1]) {
            System.out.println(count);
            return;
        }

        for(int i = 1; i < R - 2; i++) {
            for(int j = 1; j < C - 2; j++) {
                char before = map[0][0];
                if (map[i][j] != before) {
                    before = map[i][j];
                    for(int k = i + 1; k < R - 1; k++) {
                        for(int l = j + 1; l < C - 1; l++) {
                            if (map[k][l] != before && map[k][l] != map[R - 1][C - 1]) {
                                count++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}