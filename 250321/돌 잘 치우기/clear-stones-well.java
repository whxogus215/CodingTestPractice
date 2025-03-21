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

    public static int N, K, M;
    public static int[][] graph;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        M = sc.nextInt();
        
        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        Queue<Pair> queues = new ArrayDeque<>();

        int[][] visited = new int[N][N];
        int totalCount = 0;
        for(int i = 0; i < K; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            queues.add(new Pair(r, c));
            visited[r][c] = 1;
            totalCount++;
        }

        // 0인 지점을 먼저 탐색
        while(!queues.isEmpty()) {
            Pair pair = queues.poll();
            int nowY = pair.y;
            int nowX = pair.x;

            for(int i = 0; i < 4; i++) {
                int nY = nowY + dy[i];
                int nX = nowX + dx[i];

                if (canGo(nY, nX, visited)) {
                    visited[nY][nX] = 1;
                    queues.add(new Pair(nY, nX));
                    totalCount++;
                }
            }
        }

        int stoneMaxCount = 0;

        // 값이 1인 지점만 탐색
        while(!stoneQueues.isEmpty()) {
            Pair pair = stoneQueues.poll();
            int nowY = pair.y;
            int nowX = pair.x;
            int stoneCount = 1;

            for(int i = 0; i < 4; i++) {
                int nY = nowY + dy[i];
                int nX = nowX + dx[i];

                if (inRange(nY, nX) && visited[nY][nX] == 0 && isStone(nY, nX)) {
                    stoneQueues.add(new Pair(nY, nX));
                    stoneCount++;
                }
            }

            stoneMaxCount = Math.max(stoneMaxCount, stoneCount);
        }

        if (stoneMaxCount >= M) {
            totalCount += M;
        } else {
            totalCount += stoneMaxCount;
        }

        System.out.println(totalCount);
    }

    public static boolean canGo(int y, int x, int[][] visited) {
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

    public static boolean isStone(int y, int x) {
        return graph[y][x] == 1;
    }
}