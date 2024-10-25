import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(pibonacci(N));
    }

    public static int pibonacci(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return pibonacci(N - 1) + pibonacci(N - 2);
    }
}