import java.util.*;

public class Main {
    
    public static int N;
    public static int[] a = new int[50000];
    public static int[] b = new int[50000];
    public static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            b[i] = sc.nextInt();
            set.add(b[i]);
        }
        
        int idx = 0;
        for(int i = 1; i <= 2 * N; i++) {
            if (!set.contains(i)) {
                a[idx++] = i;
            }
        }

        Arrays.sort(a, 0, N);
        Arrays.sort(b, 0, N);

        int bIdx = 0;
        int max = 0;

        for(int aIdx = 0; aIdx < N; aIdx++) {
            if (a[aIdx] > b[bIdx]) {
                max++;
                bIdx++;
            }
        }

        System.out.println(max);
    }
}