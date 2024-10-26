import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(getValue(N));        
    }

    public static int getValue(int N) {
        if (N == 1) {
            return 2;
        }
        if (N == 2) {
            return 4;
        }
        return getValue(N - 1) * getValue(N - 2) % 100;
    }
}