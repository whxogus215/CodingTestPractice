import java.util.*;

public class Main {

    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            return p1.number - p2.number;
        });
        int M = 0;
        for(int i = 0; i < N; i++) {
            int count = sc.nextInt();
            int number = sc.nextInt();
            pq.add(new Pair(count, number));
            M += count;
        }

        Pair[] pairs = new Pair[N];

        int index = 0;
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            pairs[index++] = pair;
        }

        int C = Integer.MIN_VALUE;
        int front = 0, rear = N - 1;

        for(int i = 0; i <= (M - 1) / 2; i++) {
            Pair frontPair = pairs[front];
            Pair rearPair = pairs[rear];

            int sum = frontPair.number + rearPair.number;
            frontPair.count -= 1;
            rearPair.count -= 1;

            if (frontPair.count <= 0) {
                front++;
            }
            if (rearPair.count <= 0) {
                rear--;
            }

            C = Math.max(C, sum);
        }

        System.out.println(C);
    }

    static class Pair {
        int count;
        int number;

        public Pair(int count, int number) {
            this.count = count;
            this.number = number;
        }
    }
}