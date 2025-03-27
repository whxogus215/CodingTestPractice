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

    public static int N;
    public static int[][] graph;

    public static int r1, r2, c1, c2;

    public static Queue<Pair> queue = new ArrayDeque<>();

    public static final int DIR = 8;
    public static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;

        if (r1 == r2 && c1 == c2) {
            System.out.println(0);
            return ;
        }

        graph = new int[N][N];
        queue.add(new Pair(r1, c1));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int y = pair.y;
            int x = pair.x;

            for(int i = 0; i < DIR; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int value = graph[y][x] + 1;

                if (inRange(ny, nx)) {
                    queue.add(new Pair(ny, nx));
                    if (ny == r2 && nx == c2) {
                        System.out.println(value);
                        return ;
                    }
                    if (graph[ny][nx] != 0) {
                        graph[ny][nx] = Math.min(graph[ny][nx], value);
                    } else {
                        graph[ny][nx] = value;
                    }
                }
            }
        }

        System.out.println(-1);
    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}