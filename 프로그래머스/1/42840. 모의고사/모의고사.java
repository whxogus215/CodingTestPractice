import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    /**
     * 1. 각 수포자의 정답 패턴을 일차원 배열로 저장한다.
     * 2. 정답 배열의 요소와 수포자의 정답 패턴의 요소를 비교한다.
     * - 정답일 경우, 해당 수포자의 점수 +1
     * - 오답일 경우, Pass
     * 3. 수포자의 정답 패턴 길이가 N이면 i번째의 정답은 정답 패턴의 (i % N) 번째와 비교해야 한다.
     */
    public int[] solution(int[] answers) {
        List<List<Integer>> math = new ArrayList<>();
        math.add(List.of(1, 2, 3, 4, 5));
        math.add(List.of(2, 1, 2, 3, 2, 4, 2, 5));
        math.add(List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        List<Integer> scores = new ArrayList<>();
        for (List<Integer> m : math) {
            int score = 0;
            int length = m.size();
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == m.get(i % length)) {
                    score++;
                }
            }
            scores.add(score);
        }

        int maxScore = scores.stream().mapToInt(Integer::intValue).max().getAsInt();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) == maxScore) {
                answer.add(i + 1);
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}