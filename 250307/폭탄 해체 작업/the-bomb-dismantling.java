import java.util.*;

public class Main {
    
    public static int N;
    public static Pair[] pairs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        pairs = new Pair[N];

        for(int i = 0; i < N; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            pairs[i] = new Pair(score, time);
        }

        Arrays.sort(pairs, (p1, p2) -> {
            if (p1.time == p2.time) {
                return p1.score - p2.score;
            }
            return p1.time - p2.time;
        }); 
        
        int maxScore = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int t = N - 1; t >= 1; t--) {
            if (pairs[t].time >= t) {
                pq.add(pairs[t].score * -1);
            }

            if (!pq.isEmpty()) {
                int getScore = pq.poll();
                maxScore += (-1 * getScore);
            }
        }

        System.out.println(maxScore);
    }

    static class Pair {
        int score;
        int time;

        public Pair(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}