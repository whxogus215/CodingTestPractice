import java.util.*;

public class Main {

    public static int MAX = 100;
    public static int N, L;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        for(int max = MAX + 1; max >= 0; max--) {
            boolean possible = false;

            int countHighMax = 0;
            int countMaxMinusOne = 0;

            for(int i = 0; i < N; i++) {
                if (arr[i] >= max) {
                    countHighMax++;
                }
                if (arr[i] == max - 1) {
                    countMaxMinusOne++;
                }
            }

            System.out.println(max + ", " + countHighMax + ", " + countMaxMinusOne);

            if (L == 0) {
                if ((countHighMax + countMaxMinusOne) >= max) {
                    possible = true;
                }
            } else {
                if (countMaxMinusOne <= L && (countHighMax + countMaxMinusOne) >= max) {
                    possible = true;
                }    
            }

            if (possible) {
                System.out.println(max);
                return ;
            }
        }
    }
}