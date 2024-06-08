import java.util.Arrays;

class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        final int sum = Arrays.stream(numbers).sum();
        answer = (double) sum / numbers.length;
        return answer;
    }
}
