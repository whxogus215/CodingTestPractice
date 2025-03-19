import java.util.*;

class Pair {
    int y;
    int x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    public static int N, K;
    public static int[][] graph;
    public static int[][] visited;
    public static int count;

    public static Queue<Pair> queue = new ArrayDeque<>();
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        graph = new int[N][N];
        visited = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        List<Pair> pairs = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            pairs.add(new Pair(row, col));
        }

        for(Pair pair : pairs) {
            int y = pair.y - 1;
            int x = pair.x - 1;
            if (visited[y][x] == 0) {
                BFS(y, x);
            }
        }

        System.out.println(count);
    }

    public static void BFS(int y, int x) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(y, x));
        visited[y][x] = 1;
        count++;

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int nowY = pair.y;
            int nowX = pair.x;

            for(int i = 0; i < 4; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];

                if (canGo(ny, nx)) {
                    queue.add(new Pair(ny, nx));
                    visited[ny][nx] = 1;
                    count++;
                }
            }
        }
    }

    public static boolean canGo(int y, int x) {
        if (!inRange(y, x)) {
            return false;
        }
        if (visited[y][x] == 1 || graph[y][x] == 1) {
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