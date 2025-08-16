import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

class Main {

    private static final int DIR = 4;
    private static final int[] dy = {0, 1, 0, -1};
    private static final int[] dx = {1, 0, -1, 0};

    private static int M, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        int[][] tomato = new int[N][M];
        int[][] visited = new int[N][M];

        int mustCount = 0;
        int nowTomato = 0;

        Queue<Node> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int value = sc.nextInt();
                if (value != -1) {
                    if (value == 1) {
                        queue.add(new Node(i, j, 0));
                        visited[i][j] = 1;
                    }
                    mustCount++;
                }
                tomato[i][j] = value;
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            nowTomato++;
            if (nowTomato == mustCount) {
                System.out.println(node.time);
                return ;
            }

            for (int i = 0; i < DIR; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (inRange(ny, nx) && (visited[ny][nx] == 0) && tomato[ny][nx] == 0) {
                    tomato[ny][nx] = 1;
                    visited[ny][nx] = 1;
                    queue.add(new Node(ny, nx, node.time + 1));
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    static class Node {

        int y;
        int x;
        int time;

        public Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}
