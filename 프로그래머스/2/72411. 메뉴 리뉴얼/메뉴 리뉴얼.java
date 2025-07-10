import java.util.*;
/**
O(20만)
for(코스 개수) (10개)
    for(손님 : 손님들) (20)
        손님이 주문한 단품메뉴 조합 중 코스 개수에 맞는 조합 생성 (2^10 = 1000)
        생성한 조합을 HashMap에 저장(만약, 해당 조합이 기존에 있다면 + 1)


for(저장된 조합들)
    각 개수별로 저장된 조합들 중 최대값을 갖는 조합을 저장(단, 조합이 선택된 개수는 2 이상이어야 함)
    
저장된 조합을 오름차순 정렬
**/
class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<Integer, Map<String, Integer>> combiByCourseCount = new HashMap<>();
        for(int count : course) {
            combiByCourseCount.put(count, new HashMap<>());
            for(String order : orders) {
                Set<String> result = new HashSet<>();
                combination(result, order.toCharArray(), 0, count, new StringBuilder());
                Map<String, Integer> combis = combiByCourseCount.get(count);
                for(String newOrder : result) {
                    combis.put(newOrder, combis.getOrDefault(newOrder, 0) + 1);
                }
            }
        }
        
        List<String> answer = new ArrayList<>();
        for(Map.Entry<Integer, Map<String, Integer>> e : combiByCourseCount.entrySet()) {
            int count = e.getKey();
            Map<String, Integer> combi = e.getValue();
            int max = combi.values().stream().mapToInt(Integer::intValue).max().orElse(0);
            if (max < 2) {
                continue;
            }
            for(String key : combi.keySet()) {
                if (combi.get(key) == max) {
                    answer.add(key);
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    private void combination(Set<String> orders, char[] order, int idx, int count, StringBuilder sb) {
        if (sb.length() == count) {
            char[] chars = sb.toString().toCharArray();
            Arrays.sort(chars);
            orders.add(String.valueOf(chars));
            return ;
        }
        if (idx >= order.length) {
            return ;
        }
        
        sb.append(order[idx]);
        combination(orders, order, idx + 1, count, sb);
        sb.setLength(sb.length() - 1);
        
        combination(orders, order, idx + 1, count, sb);
    }
}
