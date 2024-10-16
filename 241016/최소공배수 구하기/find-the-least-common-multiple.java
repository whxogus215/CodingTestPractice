import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        printMinCommon(n, m);
    }

    public static void printMinCommon(int n, int m) {
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        int minIndex = 1, maxIndex = 1;

        while(min != max) {
            if (min < max) {
                min = Math.min(n, m) * (++minIndex);
            } else if (min > max) {
                max = Math.max(n, m) * (++maxIndex);
            }
        }
        System.out.println(min);
    }
}