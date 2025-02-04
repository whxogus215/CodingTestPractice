import java.util.*;

public class Main {
    
    public static int MAX = 100_000;
    public static int n;
    public static int[] arr = new int[MAX];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int minValue = MAX + 1;
        int maxValue = 0;

        int minIndex = -1;
        int maxIndex = -1;

        int result = 0;

        for(int i = 0; i < n; i++) {
            if (arr[i] <= minValue) {
                minValue = arr[i];
                minIndex = i;
            }
            if (arr[i] >= maxValue) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }

        if (minIndex < maxIndex) {
            result = arr[maxIndex] - arr[minIndex];
        } else {
            int min = arr[maxIndex];
            for(int i = 0; i < maxIndex; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            int first = arr[maxIndex] - min;

            int max = arr[minIndex];
            for(int i = minIndex + 1; i < n; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            int second = max - arr[minIndex];

            result = Math.max(first, second);
        }

        System.out.println(result);
    }
}