import java.util.*;

public class Main {
    public static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        printCount(N);

        System.out.println(count);
    }

    public static void printCount(int N) {
        if (N == 1) {
            return;
        }
        count++;
        if (N % 2 == 0) {
            printCount(N / 2);
        } else {
            printCount(N / 3);
        }
    }
}