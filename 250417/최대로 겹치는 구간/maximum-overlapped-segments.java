import java.util.*;
public class Main {

    public static final int OFFSET = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt() + OFFSET;
            x2[i] = sc.nextInt() + OFFSET;
        }

        int[] lines = new int[201];
        for (int i = 0; i < n; i++) {
            for(int j = x1[i]; j < x2[i]; j++) {
                lines[j]++;
            }
        }

        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            max = Math.max(max, lines[i]);
        }
        System.out.println(max);
    }
}