import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int startIdx = 0, endIdx = N - 1;
        int sum = arr[startIdx] + arr[endIdx];
        int count = 0;

        while(startIdx < endIdx) {
            if (sum > M) {
                sum -= arr[endIdx];
                sum += arr[--endIdx];
            } else {
                if (sum == M) {
                    count++;
                }
                sum -= arr[startIdx];
                sum += arr[++startIdx];
            }
        }

        System.out.println(count);
    }
}
