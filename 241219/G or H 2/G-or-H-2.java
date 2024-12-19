import java.util.*;

public class Main {
    
    private static final int MAX_N = 101;
    private static char[] arr = new char[MAX_N];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int maxPosition = -1;
        for(int i = 0; i < N; i++) {
            int position = sc.nextInt();
            char alphabet = sc.next().charAt(0);
            arr[position] = alphabet;
            maxPosition = Math.max(maxPosition, position); 
        }

        int max = 0;

        for(int i = 0; i <= maxPosition; i++) {
            if (arr[i] != 'G' && arr[i] != 'H') {
                continue;
            }
            for(int j = i; i + j <= maxPosition; j++) {
                if (arr[j] != 'G' && arr[j] != 'H') {
                    continue;
                }
                int countG = 0;
                int countH = 0;
                for(int k = i; k <= i + j; k++) {
                    if (arr[k] == 'G') {
                        countG++;
                    }
                    if (arr[k] == 'H') {
                        countH++;
                    }
                }
                if (isSatisfied(countG, countH)) {
                    max = Math.max(max, (j - i));
                }
            }
        }
        System.out.println(max);
    }

    private static boolean isSatisfied(int countG, int countH) {
        if (countG > 0 && countH == 0) {
            return true;
        }
        if (countG == 0 && countH > 0) {
            return true;
        }
        if (countG > 0 && countH > 0 && countG == countH) {
            return true;
        }
        return false;
    }
}