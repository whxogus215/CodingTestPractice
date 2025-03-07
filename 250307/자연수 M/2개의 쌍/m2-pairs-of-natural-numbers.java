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

        int[] numbers = new int[M];
        int index = 0;
        
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            for(int i = 1; i <= pair.count; i++) {
                numbers[index] = pair.number;
                index++;
            }
        }

        int C = Integer.MIN_VALUE;
        for(int i = 0; i <= (M - 1) / 2; i++) {
            int j = (M - 1) - i;
            
            int sum = numbers[i] + numbers[j];
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