import java.util.Scanner;
public class Main {
    
    public static final int OFFSET = 100;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt() + OFFSET;
            y1[i] = sc.nextInt() + OFFSET;
            x2[i] = sc.nextInt() + OFFSET;
            y2[i] = sc.nextInt() + OFFSET;
        }

        int[][] grid = new int[201][201];
        for(int i = 0; i < n; i++) {
            for(int j = x1[i]; j < x2[i]; j++) {
                for(int k = y1[i]; k < y2[i]; k++) {
                    grid[j][k] = 1;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}