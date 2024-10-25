import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(printSum(N));
    }

    public static int printSum(int N) {
        if (N == 1) {
            return 1;
        }
        return printSum(N - 1) + N;
    }
}