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

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static int N, K, M;
    public static int[][] graph;
    public static int max;

    public static List<Pair> startPairs = new ArrayList<>();
    public static List<Pair> stonePairs = new ArrayList<>();
    public static List<Pair> removePairs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        M = sc.nextInt();
        
        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 1) {
                    stonePairs.add(new Pair(i, j));
                }
            }
        }

        for(int i = 0; i < K; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            startPairs.add(new Pair(r, c));
        }

        updateMax();

        System.out.println(max);
    }

    public static void updateMax() {
        combi(0, 0);
    }

    public static void combi(int searchIndex, int count) {
        if (searchIndex == stonePairs.size() - 1) {
            if (count == M) {
                for(Pair pair : removePairs) {
                    graph[pair.y][pair.x] = 0;
                }
                BFS();
                for(Pair pair : removePairs) {
                    graph[pair.y][pair.x] = 1;
                }
            }
            return ;
        }

        removePairs.add(stonePairs.get(searchIndex));
        combi(searchIndex + 1, count + 1);
        removePairs.remove(removePairs.size() - 1);

        combi(searchIndex + 1, count);
    }

    public static void BFS() {
        Queue<Pair> queues = new ArrayDeque<>();
        int[][] visited = new int[N][N];
        int count = 0;
        
        for(Pair pair : startPairs) {
            queues.add(pair);
            visited[pair.y][pair.x] = 1;
            count++;
        }

        while(!queues.isEmpty()) {
            Pair p = queues.poll();

            for(int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (canGo(ny, nx, visited)) {
                    queues.add(new Pair(ny, nx));
                    visited[ny][nx] = 1;
                    count++;
                }
            }
        }

        max = Math.max(max, count);
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
}