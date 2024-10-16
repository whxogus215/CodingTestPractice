import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        printMaxCommon(n, m);        
    }

    public static void printMaxCommon(int n, int m) {
        int max = Math.min(n, m);
        for(int i = max; i >= 1; i--) {
            if (n % i == 0 && m % i == 0) {
                System.out.println(i);
                return ;
            }
        }
    }
}