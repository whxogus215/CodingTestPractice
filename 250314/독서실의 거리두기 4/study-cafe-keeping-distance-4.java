import java.util.*;

public class Main {
    
    public static int MAX_N = 100;
    public static int N;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        String line = sc.next();
        char[] seats = line.toCharArray();

        int[] availableIndices = new int[MAX_N];
        int index = 0;
        for(int i = 0; i < N; i++) {
            if (seats[i] == '0') {
                availableIndices[index++] = i;
            }
        }
        
        int maxDistance = 0;
        int availableSize = index;
        for(int i = 0; i < availableSize; i++) {
            for(int j = i + 1; j < availableSize; j++) {
                char[] copySeats = Arrays.copyOf(seats, N);
                int firstIndex = availableIndices[i];
                int secondIndex = availableIndices[j];
                
                copySeats[firstIndex] = '1';
                copySeats[secondIndex] = '1';

                int preIndex = -1;
                int minDistance = MAX_N;
                for(int k = 0; k < N; k++) {
                    if (copySeats[k] == '1') {
                        if (preIndex < 0) {
                            preIndex = k;
                        } else {
                            minDistance = Math.min(minDistance, k - preIndex);
                            preIndex = k;
                        }
                    }
                }
                maxDistance = Math.max(maxDistance, minDistance);
            }
        }
        System.out.println(maxDistance);
    }
}