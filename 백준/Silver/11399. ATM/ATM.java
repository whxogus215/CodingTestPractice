import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int sum = arr[0];
        int total = sum;
        int idx = 1;
        while(idx < N) {
            sum += arr[idx++];
            total += sum;
        }

        System.out.println(total);
    }
}
