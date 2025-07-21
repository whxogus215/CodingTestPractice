import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int count = 0;
        if (N <= 2) {
            System.out.println(count);
            return;
        }
        for(int i = 0; i < N; i++) {
            int target = arr[i];
            int startIdx = 0;
            int endIdx = N - 1;
            while(startIdx < endIdx) {
                int sum = arr[startIdx] + arr[endIdx];
                if (sum == target) {
                    if (startIdx != i && endIdx != i) {
                        count++;
                        break;
                    }
                    else if (startIdx == i) {
                        startIdx++;
                    } else if (endIdx == i) {
                        endIdx--;
                    }
                } else if (sum < target) {
                    startIdx++;
                } else {
                    endIdx--;
                }
            }
        }

        System.out.println(count);
    }
}
