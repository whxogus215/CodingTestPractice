import java.util.*;

public class Main {
    
    private static int[] arr = new int[20];
    private static int N;
    private static int max = -1;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int k = j + 1; k < N; k++) {
                    // carry가 아니라면
                    int result = getDigits(arr[i], arr[j], arr[k]);
                    if (result != -1) {
                        max = Math.max(max, result);
                    }
                }
            }
        }

        System.out.println(max);    
    }

    private static int getDigits(int first, int second, int third) {
        int total = 0;
        int doubleCount = 0;
        while (first != 0 || second != 0 || third != 0) {
            int result = (first % 10) + (second % 10) + (third % 10);
            if (result >= 10) {
                return -1;
            }
            total += result * Math.pow(10, doubleCount++);
            first /= 10;
            second /= 10;
            third /= 10;
        }
        return total;
    }
}