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
            int first = powers[i];
            for(int j = 0; j < NUM; j++) {
                if (i == j) {
                    continue;
                }
                for(int k = 0; k < NUM; k++) {
                    if (k == j || k == i || powers[j] == powers[k]) {
                        continue;
                    }
                    for(int l = 0; l < NUM; l++) {
                        if (l == k || l == j || l == i) {
                            continue;
                        }
                        for(int m = 0; m < NUM; m++) {
                            if (m == l || m == k || m == j || m == i || powers[m] == powers[l]) {
                                continue;
                            }
                            int team1 = first;
                            int team2 = powers[j] + powers[k];
                            int team3 = powers[l] + powers[m];

                            if (team1 == team2 || team1 == team3 || team2 == team3) {
                                continue;
                            }

                            int maxPower = Math.max(first, Math.max(powers[j] + powers[k], powers[l] + powers[m]));
                            int minPower = Math.min(first, Math.min(powers[j] + powers[k], powers[l] + powers[m]));
                            min = Math.min(min, maxPower - minPower);
                        }
                    }
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