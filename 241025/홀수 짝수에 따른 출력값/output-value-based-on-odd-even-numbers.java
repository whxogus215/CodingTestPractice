import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(f(N));
    }

    public static int f(int N) {
        if (N <= 2) {
            return N;
        }
        return N + f(N - 2);
    }
}