import java.util.*;

public class Main {

    public static int MAX_N = 100;
    public static int N;
    public static int[] arr = new int[MAX_N + 1];
    public static int[][] lines;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        lines = new int[N][2];
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            lines[i] = new int[]{a, b};

            for(int j = a; j <= b; j++) {
                arr[j] += 1;
            }
        }

        int count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int k = j + 1; k < N; k++) {
                    if (isCorrect(new int[]{i, j, k})) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    public static boolean isCorrect(int[] componenets) {
        int[] copyArr = Arrays.copyOf(arr, arr.length);

        for(int i = 0; i < componenets.length; i++) {
            int index = componenets[i];
            int a = lines[index][0];
            int b = lines[index][1];

            for(int j = a; j <= b; j++) {
                copyArr[j] -= 1;
            }
        }

        for(int i = 0; i < copyArr.length; i++) {
            if (copyArr[i] > 1) {
                return false;
            }
        }
        return true;
    }
}