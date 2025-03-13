import java.util.*;

public class Main {
    
    public static int C, N;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();
        
        TreeSet<Integer> redStones = new TreeSet<>();
        List<BlackStone> blackStones = new ArrayList<>();

        // O(CLogC)
        for(int i = 0; i < C; i++) {
            int redStone = sc.nextInt();
            redStones.add(redStone);
        }

        for(int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            blackStones.add(new BlackStone(A, B));
        }

        // O(NlogN)
        Collections.sort(blackStones, (b1, b2) -> b1.B - b2.B);

        int maxPair = 0;
        // O(NlogC)
        for(BlackStone blackStone : blackStones) {
            int a = blackStone.A;
            int b = blackStone.B;
            int redStone = redStones.ceiling(a);

            if (redStones.ceiling(a) != null) {
                if (redStone <= b) {
                    maxPair++;
                    redStones.remove(redStone);
                }
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