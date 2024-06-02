import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
