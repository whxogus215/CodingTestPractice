import java.util.*;

public class Main {
    
    private static int[] heights = new int[101];
    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int k = j + 1; k < N; k++) {
                    if (isCorrect(i, j, k)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isCorrect(int i, int j, int k) {
        if (heights[i] <= heights[j] && heights[j] <= heights[k]) {
            return true;
        }
        return false;
    }
}