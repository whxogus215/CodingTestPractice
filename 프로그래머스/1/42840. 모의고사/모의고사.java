import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Solution {

    /**
     * i번째 문제의 정답은 i % N (N은 패턴의 개수)번째와 비교한다.
     * 각 수포자별로, 문제를 비교한 후 총점을 계산한다.
     * 최대 점수를 구한다.
     * 최대 점수와 같은 번호를 뽑는다.
     * 번호를 오룸차순으로 정렬하여 반환한다.
     */
    public int[] solution(int[] answers) {
        int[][] pattern = new int[][]{
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length; i++) {
            int result = 0;
            for (int j = 0; j < answers.length; j++) {
                int length = pattern[i].length;
                if (answers[j] == pattern[i][j % length]) {
                    result += 1;
                }
            }
            map.put(i + 1, result);
        }

        final int max = map.values().stream().mapToInt(Integer::intValue).max().getAsInt();
        final List<Entry<Integer, Integer>> collected =
            map.entrySet().stream().filter(e -> e.getValue().equals(max)).collect(Collectors.toList());
        return collected.stream().map(Entry::getKey).sorted().mapToInt(Integer::intValue).toArray();
    }
}
