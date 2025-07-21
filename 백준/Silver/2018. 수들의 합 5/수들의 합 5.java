import java.io.IOException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 1, count = 1;
        int startIdx = 1, endIdx = 1;

        while(endIdx < N) {
            if (sum == N) {
                count++;
                sum += ++endIdx;
            } else if (sum < N) {
                sum += ++endIdx;
            } else {
                sum -= startIdx++;
            }
        }

        System.out.println(count);
    }
}
