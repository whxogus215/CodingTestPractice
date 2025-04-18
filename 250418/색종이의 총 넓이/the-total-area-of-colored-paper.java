import java.util.Scanner;
public class Main {

    public static final int OFFSET = 100;
    public static final int LENGTH = 8;
    public static int[][] grid = new int[2 * OFFSET + 1][2 * OFFSET + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt() + OFFSET;
            y[i] = sc.nextInt() + OFFSET;

            for(int j = x[i]; j < x[i] + LENGTH; j++) {
                for(int k = y[i]; k < y[i] + LENGTH; k++) {
                    if (grid[j][k] == 1) {
                        continue;
                    }
                    grid[j][k] = 1;
                    sum++;
                }
            }
        }
        System.out.println(sum);        
    }
}