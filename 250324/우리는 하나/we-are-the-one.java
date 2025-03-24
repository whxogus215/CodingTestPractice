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
    
    public static int N, K, U, D;
    public static int[][] graph;
    public static boolean[][] visited;

    public static List<Pair> contries = new ArrayList<>();
    public static List<Pair> result = new ArrayList<>();

    public static Queue<Pair> queues = new ArrayDeque<>();

    public static final int DIR = 4;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static int maxContries;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        graph = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
                contries.add(new Pair(i, j));
            }
        }

        // N * N개 중 K개를 뽑는 조합을 진행한다.
        combi(0, 0); // 0번 인덱스부터 뽑는 조합을 시작, 현재 뽑힌 개수는 0개

        System.out.println(maxContries);
    }

    public static void combi(int index, int count) {
        if (index == contries.size()) {
            if (result.size() == K) {
                // 뽑인 K개에 대한 완전탐색 진행하기
                BFS();
            }
            return ;
        }

        // 해당 요소를 포함
        result.add(contries.get(index));
        combi(index + 1, count + 1);
        result.remove(result.size() - 1);

        // 해당 요소를 포함 X
        combi(index + 1, count);
    }

    public static void BFS() {
        int totalContries = 0;

        initialize();
        for(Pair p : result) {
            queues.add(p);
            visited[p.y][p.x] = true;
            totalContries++;
        }

        while(!queues.isEmpty()) {
            Pair pair = queues.poll();

            for(int i = 0; i < DIR; i++) {
                int ny = pair.y + dy[i];
                int nx = pair.x + dx[i];
                if (!inRange(ny, nx)) {
                    continue;
                }
                if (canGo(pair.y, pair.x, ny, nx)) {
                    visited[ny][nx] = true;
                    totalContries++;
                }
            }
        }

        maxContries = Math.max(maxContries, totalContries);
    }

    public static void initialize() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static boolean canGo(int y1, int x1, int y2, int x2) {
        int diffHeight = Math.abs(graph[y1][x1] - graph[y2][x2]);
        return diffHeight >= U && diffHeight <= D;        
    }
    
    public static boolean inRange(int y, int x) {
        if (y < 0 || y >= N || x < 0 || x >= N) {
            return false;
        }
        return true;
    }
}