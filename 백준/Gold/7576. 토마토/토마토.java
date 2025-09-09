import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static final int DIR = 4;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] tomato = new int[N][M];
        int current = 0;
        int must = 0;
        Queue<Tomato> queue = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int value = sc.nextInt();
                tomato[i][j] = value;
                if (value != -1) {
                    must++;
                    if (value == 1) {
                        queue.add(new Tomato(i, j, 0));
                    }
                }
            }
        }
            
        int minDay = 0;
        while(!queue.isEmpty()) {
            Tomato t = queue.poll();
            current++;
            minDay = Math.max(minDay, t.day);

            for(int i = 0; i < DIR; i++) {
                int ny = t.y + dy[i];
                int nx = t.x + dx[i];

                if ((ny >= 0 && ny < N && nx >= 0 && nx < M) && tomato[ny][nx] == 0) {
                    tomato[ny][nx] = 1;
                    queue.add(new Tomato(ny, nx, t.day + 1));
                }
            }
        }

        if (current < must) {
            System.out.println(-1);           
        } else {
            System.out.println(minDay);
        }
    }

    static class Tomato {
        int y;
        int x;
        int day;

        public Tomato(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}
