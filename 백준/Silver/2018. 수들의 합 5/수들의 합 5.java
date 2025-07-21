import java.io.IOException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= N; i++) {
            int sum = N;
            for (int j = i; j <= N; j++) {
                if (sum > 0) {
                    sum -= j;
                } else {
                    break;
                }
            }
            if (sum == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
