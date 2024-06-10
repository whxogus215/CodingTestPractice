import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

    /**
     * 클리어하지 못한 사용자는 stages에서 N번 스테이지와 같은 값을 갖는 요소의 개수이다.
     * 각 스테이지별 실패율을 계산하기 위해 1번 스테이지부터 N번 스테이지 순으로 순회한다.
     * 실패율의 분모 : 스테이지 번호보다 크거나 같은 요소의 개수 (분모의 개수는 이전 스테이지에 도달한 인원만큼 감소한다.)
     * 실패율의 분자 : 스테이지 번호와 같은 요소의 개수
     * 각 스테이지의 단계 숫자와 실패율을 한 세트로 관리할 수 있어야 한다.
     */
    public int[] solution(int N, int[] stages) {
        int[] stageArr = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            stageArr[stages[i]] += 1;
        }

        int total = stages.length; // 총 도전자 수
        Map<Integer, Double> ratio = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            if (stageArr[i] == 0 || total == 0) { // 0으로 나누었을 경우, NaN이 발생하는 문제를 해결하기 위한 조건문
                ratio.put(i, 0.);
            } else {
                ratio.put(i,(double) stageArr[i] / total);
                total -= stageArr[i];
            }
        }

        return ratio.entrySet()
            .stream()
            .sorted((e1, e2) -> (Double.compare(e2.getValue(),e1.getValue())))
            .mapToInt(Entry::getKey)
            .toArray();
    }
}
