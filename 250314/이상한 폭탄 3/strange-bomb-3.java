import java.util.*;

public class Main {

    public static int N, K;
    public static int[] bombs;
    public static Set<Integer> bombNumbs = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        bombs = new int[N];
        for(int i = 0; i < N; i++) {
            bombs[i] = sc.nextInt();
            bombNumbs.add(bombs[i]);
        }

        int maxBombNum = 0;
        int maxCount = 0;

        Integer[] arr = bombNumbs.toArray(new Integer[bombNumbs.size()]);

        for(int j = 0; j < arr.length; j++) {
            int num = arr[j];
            int pre = -1;
            int count = 0;
            for(int i = 0; i < N; i++) {
                if (bombs[i] == num) {
                    if (pre < 0) {
                        pre = i;
                        continue;
                    }
                    if (i - pre <= K) {
                        count++;
                        pre = i;
                    }
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxBombNum = num;
            }
        }

        System.out.println(maxBombNum);
    }
}