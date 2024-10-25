import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println((int) printTotalSquare(N));
    }

    public static double printTotalSquare(int N) {
        if (N < 10) {
            return Math.pow(N, 2);
        }
        return printTotalSquare(N / 10) + Math.pow(N % 10, 2);
    }
}