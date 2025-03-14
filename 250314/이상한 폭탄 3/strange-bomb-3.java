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
            int index = 0;
            int[] bombIndices = new int[N];
            for(int i = 0; i < N; i++) {
                if (bombs[i] == num) {
                    bombIndices[index++] = i;
                }
            }

            int count = 0;
            for(int i = 0; i < index - 1; i++) {
                int pair = 0;
                while(i < index - 1 && bombIndices[i + 1] - bombIndices[i] <= K) {
                    pair++;
                    i++;
                }
                if (pair > 0) {
                    count += (pair + 1);
                }
            }

            if (count > maxCount) {
                maxCount = count;
                maxBombNum = num;
            } else if (count == maxCount) {
                maxBombNum = Math.max(maxBombNum, num);
            }
        }

        System.out.println(maxBombNum);
    }
}