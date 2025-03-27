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

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    int value = graph[y][x] + 1;
                    if (isAvail(y, x, i, j)) {
                        queue.add(new Pair(i, j));
                        if (i == r2 && j == c2) {
                            System.out.println(value);
                            return ;
                        }
                        if (graph[i][j] != 0) {
                            graph[i][j] = Math.min(graph[i][j], value);
                        } else {
                            graph[i][j] = value;
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }

    public static boolean isAvail(int y1, int x1, int y2, int x2) {
        return inRange(y2, x2) && Math.abs(y1 - y2) + Math.abs(x1 - x2) == 3;
    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}