import java.util.*;

public class Main {
    
    public static int C, N;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();
        
        PriorityQueue<Integer> redStones = new PriorityQueue<>(); // 최소 힙
        PriorityQueue<BlackStone> blackStones = new PriorityQueue<>(
            // A를 기준으로 오름차순, A가 같으면 B를 기준으로 오름차순
            (b1, b2) -> {
                if (b1.A == b2.A) {
                    return b1.B - b2.B;
                }
                return b1.A - b2.A;
            }
        );

        for(int i = 0; i < C; i++) {
            int redStone = sc.nextInt();
            redStones.add(redStone);
        }

        for(int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            blackStones.add(new BlackStone(A, B));
        }

        int maxPair = 0;
        for(int i = 0; i < C; i++) {
            if (blackStones.isEmpty()) {
                break;
            }
            int redStone = redStones.peek();
            BlackStone blackStone = blackStones.peek();
            if (redStone < blackStone.A) {
                redStones.poll();
            } else if (redStone > blackStone.B) {
                blackStones.poll();
            } else {
                redStones.poll();
                blackStones.poll();
                maxPair++;
            }
        }
        System.out.println(maxPair);
    }

    static class BlackStone {
        int A;
        int B;

        public BlackStone(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}