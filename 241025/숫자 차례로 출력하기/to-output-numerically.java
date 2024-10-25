import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        printNumber(N);
        System.out.println();
        printNumberByReverse(N);
    }

    public static void printNumber(int N) {
        if (N == 0) {
            return ;
        }
        printNumber(N - 1);
        System.out.print(N + " ");
    }

    public static void printNumberByReverse(int N) {
        if (N == 0) {
            return ;
        }
        System.out.print(N + " ");
        printNumberByReverse(N - 1);
    }
}