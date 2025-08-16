import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Main {

    private static final int MAX = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int time = 0;
        boolean[] visited = new boolean[2 * MAX + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        visited[N] = true;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int level = 0; level < queueSize; level++) {
                int nowPosition = queue.poll();
                if (nowPosition == K) {
                    System.out.println(time);
                    return ;
                }

                int[] newPositions = new int[3];
                newPositions[0] = nowPosition * 2;
                newPositions[1] = nowPosition - 1;
                newPositions[2] = nowPosition + 1;

                for (int i = 0; i < newPositions.length; i++) {
                    int position = newPositions[i];
                    if (position >= 0 && position <= 2 * MAX && !visited[position]) {
                        queue.add(position);
                        visited[position] = true;
                    }
                }
            }

            time++;
        }
        System.out.println(-1);
    }
}
