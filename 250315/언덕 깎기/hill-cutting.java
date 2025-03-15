import java.util.*;

public class Main {
    
    public static int MAX_N = 1000;
    public static int MAX_H = 100;
    public static int DIFF = 17;

    public static int N;
    public static int[] heights;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        heights = new int[N];
        for(int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i + DIFF <= MAX_H; i++) {
            int cost = 0;
            for(int j = 0; j < N; j++) {
                if (heights[j] < i) {
                    cost += (i - heights[j]) * (i - heights[j]);
                } else if (heights[j] > i + DIFF) {
                    cost += (heights[j] - i - DIFF) * (heights[j] - i - DIFF);
                } else {
                    continue;
                }
            }
            minCost = Math.min(minCost, cost);
        }
        System.out.println(minCost);
    }
}