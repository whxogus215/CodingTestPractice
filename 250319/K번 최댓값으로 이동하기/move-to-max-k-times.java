import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    public static int N, K;
    public static int r, c;
    public static int[][] graph;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        while(K > 0) {
            BFS(r, c, graph[r][c]);
            K--;
        }

        System.out.println((r + 1) + " " + (c + 1));
    }

    public static void BFS(int row, int col, int max) {

        int[][] visited = new int[N][N];
        Queue<Pair> queue = new ArrayDeque<>();
        visited[row][col] = 1;
        queue.add(new Pair(row, col));
        int newMax = 0;

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int nowY = pair.y;
            int nowX = pair.x;

            for(int i = 0; i < 4; i++) {
                int nY = nowY + dy[i];
                int nX = nowX + dx[i];

                if (canGo(nY, nX, max, visited)) {
                    visited[nY][nX] = 1;
                    queue.add(new Pair(nY, nX));
                    newMax = Math.max(newMax, graph[nY][nX]);
                }
            }
        }

        // 방문한 지점 중 최댓값을 만족하는 row, col 값을 갱신
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (visited[i][j] == 1 && graph[i][j] == newMax) {
                    r = i;
                    c = j;
                    return ;
                }
            }
        }
    }

    public static boolean canGo(int y, int x, int max, int[][] visited) {
        if (!inRange(y, x)) {
            return false;
        }
        if (visited[y][x] == 1 || graph[y][x] >= max) {
            return false;
        }
        return true;
    }

    public static boolean inRange(int y, int x) {
        if (y < 0 || y >= N || x < 0 || x >= N) {
            return false;
        }
        return true;
    }
}