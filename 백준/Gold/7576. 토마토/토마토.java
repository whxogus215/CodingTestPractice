import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Main {

    static class Tomato {

        int y;
        int x;
        int day;

        public Tomato(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }

    private static final int[] dy = {0, 1, 0, -1};
    private static final int[] dx = {1, 0, -1, 0};
    private static final int DIR = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] tomatos = new int[N][M];
        Queue<Tomato> queue = new ArrayDeque<>();

        int mustTomato = 0;
        int currentTomato = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int value = sc.nextInt();
                if (value != -1) {
                    mustTomato++;
                    if (value == 1) {
                        queue.add(new Tomato(i, j, 0));
                    }
                }
                tomatos[i][j] = value;
            }
        }

        int minDay = -1;
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            currentTomato++;

            if (currentTomato == mustTomato) {
                minDay = tomato.day;
                break;
            }

            for (int i = 0; i < DIR; i++) {
                int ny = tomato.y + dy[i];
                int nx = tomato.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && tomatos[ny][nx] == 0) {
                    queue.add(new Tomato(ny, nx, tomato.day + 1));
                    tomatos[ny][nx] = 1;
                }
            }
        }

        System.out.println(minDay);
    }
}
