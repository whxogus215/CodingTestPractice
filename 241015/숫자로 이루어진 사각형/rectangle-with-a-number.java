import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        printRect(N);
    }

    public static void printRect(int N) {
        int cnt = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (cnt == 10) {
                    cnt = 1;
                }
                System.out.print(cnt + " ");
                cnt++;
            }
            System.out.println();
        }
    }
}