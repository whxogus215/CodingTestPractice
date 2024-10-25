import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        printNumber(N);
    }

    public static void printNumber(int N) {
        if (N == 0) {
            return ;
        }

        System.out.print(N + " ");
        printNumber(N - 1);
        System.out.print(N + " ");
    }
}