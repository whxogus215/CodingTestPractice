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

    public static final int WATER = 0;
    public static final int ICE = 1;

    public static int N, M;
    public static int[][] graph;
    public static boolean[][] availMelt;

    public static int totalIce, meltIce;
    public static int meltTime;

    public static int DIR = 4;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static Queue<Pair> queues = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int value = sc.nextInt();
                graph[i][j] = value;
                if (value == 1) { // 빙하일 경우
                    totalIce += 1;
                }
            }
        }

        // 완탐을 통해, 녹을 수 있는 빙하를 탐색한다.
        availMelt = new boolean[N][M];
        
        while(totalIce > 0) {
            simulate();
        }

        System.out.println(meltTime + " " + meltIce);
    }

    public static void simulate() {
        meltTime++;

        // BFS로 물 탐색
        BFS();
        // 녹일 수 있는 빙하 탐색 후, 녹이기
        melt();
    }

    public static void BFS() {
        initialize();

        // 0, 0에서 시작!
        queues.add(new Pair(0 ,0));
        availMelt[0][0] = true;

        while(!queues.isEmpty()) {
            Pair pair = queues.poll();

            for(int i = 0; i < DIR; i++) {
                int ny = pair.y + dy[i];
                int nx = pair.x + dx[i];

                if (inRange(ny, nx) && graph[ny][nx] == WATER && !availMelt[ny][nx]) {
                    queues.add(new Pair(ny, nx));
                    availMelt[ny][nx] = true;
                }
            }
        }
    }

    public static void initialize() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                availMelt[i][j] = false;
            }
        }
    }

    public static void melt() {
        // 빙하인 지점의 4방 중 녹을 수 있는 물이 있다면 녹인다.
        meltIce = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (graph[i][j] == WATER) {
                    continue;
                }

                for(int d = 0; d < DIR; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];

                    if (inRange(ny, nx) && availMelt[ny][nx]) {
                        graph[i][j] = WATER;
                        meltIce++;
                        break;
                    }
                }
            }
        }

        totalIce -= meltIce;
    }

    public static boolean inRange(int y, int x) {
        if (y < 0 || y >= N || x < 0 || x >= M) {
            return false;
        }
        return true;
    }
}