import java.util.*;

public class Main {
    
    public static int NUM = 5;
    public static int[] powers = new int[NUM];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalSum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < NUM; i++) {
            powers[i] = sc.nextInt();
            totalSum += powers[i];
        }
        for(int i = 0; i < NUM; i++) {
            for(int j = i + 1; j < NUM; j++) {
                if (powers[i] == powers[j]) {
                    continue;
                }
                int firstSum = powers[i] + powers[j];
                for(int k = j; k < NUM; k++) {
                    if (k == j) {
                        continue;
                    }
                    int secondSum = totalSum - firstSum - powers[k];
                    min = Math.min(Math.min(firstSum, secondSum), powers[k]);
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}