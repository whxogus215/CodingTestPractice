import java.util.*;

public class Main {

    private static final int MAX_N = 100;
    private static char[] arr = new char[MAX_N + 1];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int minPosition = 101;
        int maxPosition = -1;
        
        for(int i = 0; i < N; i++) {
            int position = sc.nextInt();
            char alphabet = sc.next().charAt(0);
            arr[position] = alphabet;

            minPosition = Math.min(minPosition, position);
            maxPosition = Math.max(maxPosition, position);
        }

        int maxSize = -1;
        for(int i = minPosition; i <= maxPosition; i++) {
            if (arr[i] != 'G' && arr[i] != 'H') {
                continue;
            }
            for(int j = 0; j <= maxPosition - i; j++) {
                if (arr[i + j] != 'G' && arr[i + j] != 'H') {
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
                    maxSize = Math.max(maxSize, j);
                }
            }
        }
        System.out.println(maxSize);        
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