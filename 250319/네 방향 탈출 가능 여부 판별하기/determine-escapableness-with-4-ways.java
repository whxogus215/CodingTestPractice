import java.util.*;

public class Main {

    public static int N, M;
    public static int[][] graph;
    public static int[][] visited;

    public static Queue<Pair> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N][M];
        visited = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        if (isPossible(0, 0)) {
            System.out.println(1);
            return ;
        } else {
            System.out.println(0);
            return ;
        }
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static boolean isPossible(int y, int x) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        visited[y][x] = 1;
        queue.add(new Pair(y, x));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int nowY = pair.y;
            int nowX = pair.x;

            if ((nowY == N - 1) && (nowX == M - 1)) {
                return true;
            }
            // 4방향 탐색 후, 조건에 맞으면 방문처리 + 큐에 저장
            for(int i = 0; i < 4; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];

                if (canGo(ny, nx)) {
                    visited[ny][nx] = 1;
                    queue.add(new Pair(ny, nx));
                }
            }
        }

        return false;
    }

    public static boolean canGo(int y, int x) {
        if (!inRange(y, x)) {
            return false;
        }
        if (visited[y][x] == 1 || graph[y][x] == 0) {
            return false;
        }
        return true;
    }

    public static boolean inRange(int y, int x) {
        if (y < 0 || y >= N || x < 0 || x >= M) {
            return false;
        }
        return true;
    }
}