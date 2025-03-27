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

    public static int N, M;
    public static int[][] graph;
    public static int[][] valueGraph;
    public static int[][] visited;

    public static Queue<Pair> queue = new ArrayDeque<>();

    public static final int DIR = 4;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        valueGraph = new int[N][M];
        visited = new int[N][M];
        
        queue.add(new Pair(0, 0));
        visited[0][0] = 1;

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int y = pair.y;
            int x = pair.x;

            for(int i = 0; i < DIR; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (canGo(ny, nx)) {
                    queue.add(new Pair(ny, nx));
                    visited[ny][nx] = 1;
                    valueGraph[ny][nx] = valueGraph[y][x] + 1;
                }
            }
        }

        if (valueGraph[N - 1][M - 1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(valueGraph[N - 1][M - 1]);
        }
    }

    public static boolean canGo(int y, int x) {
        if (!inRange(y, x)) {
            return false;
        }
        return visited[y][x] == 0 && graph[y][x] == 1;
    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}