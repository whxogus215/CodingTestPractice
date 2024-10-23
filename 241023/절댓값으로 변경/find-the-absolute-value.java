import java.util.*;

public class Main {
    public static final int MAX_N = 50;
    public static int[] arr = new int[MAX_N];
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        convertAbs(arr);

        for(int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void convertAbs(int[] arr) {
        for(int i = 0; i < N; i++) {
            if (arr[i] < 0) {
                arr[i] *= -1;
            }
        }
    }
}