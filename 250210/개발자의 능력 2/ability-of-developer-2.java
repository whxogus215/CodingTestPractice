import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] powers = new int[7];

        int sum = 0;
        for(int i = 1; i <= 6; i++) {
            powers[i] = sc.nextInt();
            sum += powers[i];
        }
        
        int result = Integer.MAX_VALUE;
        for(int i = 2; i <= 6; i++) {
            int remain = sum;
            int power1 = powers[1] + powers[i];
            remain -= power1;
            for(int j = 2; j <= 6; j++) {
                if (j == i) {
                    continue;
                }
                for(int k = 2; k <= 6; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    int power2 = powers[j] + powers[k];
                    int power3 = remain - power2;

                    int max = Math.max(Math.max(power1, power2), power3);
                    int min = Math.min(Math.min(power1, power2), power3);

                    result = Math.min(result, max - min);
                }
            }
        }
        System.out.println(result);
    }
}