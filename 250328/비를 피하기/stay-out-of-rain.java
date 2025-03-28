import java.util.*;

class Pair {
    int x;
    int y;
    int cost;

    public Pair(int y, int x, int cost) {
        this.y = y;
        this.x = x;
        this.cost = cost;
    }
}

public class Main {

    public static int N, H, M;
    public static int[][] graph;
    public static int[][] answer;
    public static int[][] visited;

    public static Queue<Pair> queue = new ArrayDeque<>();
    public static List<Pair> humans = new ArrayList<>();

    public static final int DIR = 4;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static final int AVAIL = 0;
    public static final int WALL = 1;
    public static final int HUMAN = 2;
    public static final int BARRIER = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        H = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == HUMAN) {
                    humans.add(new Pair(i, j, 0));
                }
            }
        }

        answer = new int[N][N];
        for(Pair p : humans) {
            initailize();
            BFS(p);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void initailize() {
        if (visited == null) {
            visited = new int[N][N];
            return ;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                visited[i][j] = 0;
            }
        }
    }

    public static void BFS(Pair pair) {
        queue.clear();  // 큐를 완전히 비우고 시작

        int startY = pair.y;
        int startX = pair.x;

        queue.add(pair);
        visited[startY][startX] = 1;

        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int y = p.y;
            int x = p.x;

            for(int i = 0; i < DIR; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (!inRange(ny, nx)) {
                    continue;
                }

                if (graph[ny][nx] == BARRIER) {
                    answer[startY][startX] = p.cost + 1;
                    return ;
                }

                if (graph[ny][nx] != WALL && visited[ny][nx] == 0) {
                    queue.add(new Pair(ny, nx, p.cost + 1));
                    visited[ny][nx] = 1;
                }
            }
        }

        answer[startY][startX] = -1;
    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}