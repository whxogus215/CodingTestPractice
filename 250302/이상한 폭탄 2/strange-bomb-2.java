import java.util.*;

public class Main {
    
    public static int N;
    public static int K;

    public static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        for(int i = 0; i < N; i++) {
            Integer index = i;
            int number = sc.nextInt();
            if (map.containsKey(number)) {
                List<Integer> indexs = map.get(number);
                indexs.add(index);
            } else {
                List<Integer> indexs = new ArrayList<>();
                indexs.add(index);
                map.put(number, indexs);
            }
        }

        int maxNum = -1;

        for(Integer bombNum : map.keySet()) {
            List<Integer> indexs = map.get(bombNum);
            for(int i = 0; i < indexs.size() - 1; i++) {
                if (indexs.get(i + 1) - indexs.get(i) <= K) {
                    maxNum = Math.max(maxNum, bombNum);
                }
            }
        }

        System.out.println(maxNum);
    }
}