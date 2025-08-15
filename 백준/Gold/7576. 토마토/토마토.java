import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Main {

    private static final int VISIT = 100;
    private static final int DIR = 4;

    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    private static int M, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        int[][] graph = new int[N][M];
        Queue<Node> queue = new ArrayDeque<>();

        int totalCount = M * N;
        int notTomato = 0;
        int currentTomato = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int value = sc.nextInt();
                graph[i][j] = value;
                if (value == -1) {
                    notTomato++;
                }
                if (value == 1) {
                    currentTomato++;
                    queue.add(new Node(i, j));
                }
            }
        }
        int mustTomato = totalCount - notTomato;

        int minDate = 0;

        while (!queue.isEmpty()) {
            if (currentTomato == mustTomato) {
                System.out.println(minDate);
                return ;
            }

            int level = queue.size();
            for (int j = 0; j < level; j++) {
                Node node = queue.poll();
                graph[node.y][node.x] = VISIT;

                for(int i = 0; i < DIR; i++) {
                    int ny = node.y + dy[i];
                    int nx = node.x + dx[i];

                    if (inRange(ny, nx) && graph[ny][nx] != VISIT) {
                        if (graph[ny][nx] == 0) {
                            queue.add(new Node(ny, nx));
                            currentTomato++;
                            graph[ny][nx] = VISIT;
                        }
                    }
                }
            }

            minDate++;
        }

        System.out.println(-1);
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    static class Node {

        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
