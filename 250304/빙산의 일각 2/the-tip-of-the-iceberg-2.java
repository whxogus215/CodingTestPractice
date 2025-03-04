import java.util.*;

public class Main {
    
    public static int N;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[] iceMountains = new int[N];
        int maxHeight = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            iceMountains[i] = sc.nextInt();
            maxHeight = Math.max(maxHeight, iceMountains[i]);
        }

        // 해수면 높이 : 1 ~ (최대 높이 - 1)
        int maxCount = 0;
        for(int i = 1; i <= maxHeight - 1; i++) {
            int[] copys = Arrays.copyOf(iceMountains, N);
            boolean isDrown = false;
            int count = 0;
            for(int j = 0; j < N; j++) {
                copys[j] -= i;
                if (copys[j] > 0) {
                    isDrown = true;
                } else {
                    if (isDrown) {
                        count++;
                        isDrown = false;
                    }
                }
            }
            if (isDrown) {
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        System.out.println(maxCount);
    }
}