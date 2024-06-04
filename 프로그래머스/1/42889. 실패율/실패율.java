import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

    /**
     * 1. 각 스테이지에 도달한 인원 수를 구한다. (제일 중요! : 문제를 해석할 때, 메모리 기준 말고 개념적인 그림으로 먼저 이해하기!)
     * 2. 각 스테이지별 실패율을 계산한다.
     * 3. 실패율을 기준으로 내림차순 정렬한다. - 실패율의 분모에 해당하는 값은 스테이지가 진행될 수록 점점 줄어든다.
     * 4. 정렬된 인덱스를 기반으로 배열을 반환한다.
     */
    public int[] solution(int N, int[] stages) {
        int[] challenger = new int[N + 2];
        for (int i = 0; i < stages.length; i++) { // 도전자별 스테이지 통과 개수를 탐색하며 스테이지별 통과 인원을 저장
            challenger[stages[i]] += 1;
        }

        Map<Integer, Double> fails = new HashMap<>(); // 인덱스 값을 반환하기 위해 Map을 사용!!!
        double total = stages.length; // 실패율의 분모에 해당하는 값

        // 스테이지별 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                fails.put(i, 0.);
            } else {
                fails.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }

        return fails.entrySet().stream()
            .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())) // 실패율(Double) 기준으로 내림차순
            .mapToInt(Entry::getKey).toArray(); // mapToInt를 사용해 IntStream으로 변환해야 int[]로 변환할 수 있음.
    }
}

//class Solution {
//
//    /**
//     * 1. 1부터 N까지 돌면서 각 실패율을 계산한다.
//     * 2. 계산한 실패율을 내림차순으로 정렬한다.
//     * 3. 정렬한 인덱스를 배열로 담아 반환한다.
//     * 4. 실패율 : (N과 같은 값을 갖는 요소의 개수) / (값이 N보다 크거나 같은 요소의 개수)
//     */
//    public int[] solution(int N, int[] stages) {
//        double[] result = new double[N + 1];
//        int[] clone = stages.clone();
//        Arrays.sort(clone); // 오름차순 정렬
//        for (int i = 1; i <= N; i++) {
//            int start = 0;
//            int end = 0;
//            boolean isFirst = true;
//            for (int j = 0; j < clone.length; j++) {
//                if (clone[j] >= i && isFirst) {
//                    start = j;
//                    end = j;
//                    isFirst = false;
//                } else if (clone[j] == i) {
//                    end = j;
//                }
//            }
//            int totalPlayer = clone.length - start;
//            int notClearPlayer;
//            if (start != end) {
//                notClearPlayer = end - start + 1;
//            } else {
//                notClearPlayer = 0;
//            }
//            double failRatio = (double) notClearPlayer / totalPlayer;
//            result[i] = failRatio;
//        }
//
//    }
//}
