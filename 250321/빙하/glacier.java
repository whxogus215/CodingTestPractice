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
    public static boolean[][] availWater;
    public static boolean[][] isMeltRightNow;

    public static int remainIce, meltIceCount;
    public static int meltTime;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static Queue<Pair> queues = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N][M];
        availWater = new boolean[N][M];
        isMeltRightNow = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int value = sc.nextInt();
                graph[i][j] = value;
                if (value == 1) { // 빙하일 경우
                    remainIce += 1;
                } else { // 물일 경우
                    availWater[i][j] = true;
                }
            }
        }

        while(remainIce > 0) {
            BFS();
            meltTime += 1;
        }

        System.out.println(meltTime + " " + meltIceCount);
    }

    public static void BFS() {
        int nowMeltIceCount = 0;        
        availWater = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (graph[i][j] == 1) { // 빙하일 때
                    queues.add(new Pair(i, j));
                } else { // 물일 때
                    // 해당 물이 빙하에 둘러쌓여 있지 않은지 확인
                    if (isSurroudIce(i, j)) {
                        availWater[i][j] = false;
                    } else {
                        availWater[i][j] = true;
                    }
                }
            }
        }

        List<Pair> meltPairs = new ArrayList<>();
        while(!queues.isEmpty()) {
            boolean isAvailMelt = false;
            Pair pair = queues.poll();
            for(int i = 0; i < 4; i++) {
                int ny = pair.y + dy[i];
                int nx = pair.x + dx[i];
                
                if (!inRange(ny, nx)) {
                    continue;
                }
                if (graph[ny][nx] == 0 && availWater[ny][nx] == true) {
                    isAvailMelt = true;
                }
            }
            if (isAvailMelt) {
                meltPairs.add(pair);
                nowMeltIceCount += 1;
            }
        }

        for(Pair p : meltPairs) {
            graph[p.y][p.x] = 0;
        }

        remainIce -= nowMeltIceCount;
        meltIceCount = nowMeltIceCount;
    }

    public static boolean inRange(int y, int x) {
        if (y < 0 || y >= N || x < 0 || x >= M) {
            return false;
        }
        return true;
    }

    public static boolean isSurroudIce(int y, int x) {
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if (!inRange(ny, nx)) {
                return false;
            }
            if (graph[ny][nx] == 0) {
                return false;
            }
        }
        return true;
    }
}