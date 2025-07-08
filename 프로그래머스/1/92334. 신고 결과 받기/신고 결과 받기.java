import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        for(String r : report) {
            String[] splited = r.split(" ");
            String reporter = splited[0];
            String id = splited[1];
            
            if (!reportMap.containsKey(id)) {
                reportMap.put(id, new HashSet<String>());
            }
            reportMap.get(id).add(reporter);
        }
        
        Map<String, Integer> countMap = new HashMap<>();
        for(Map.Entry<String, Set<String>> e : reportMap.entrySet()) {
            Set<String> reporters = e.getValue();
            if (reporters.size() < k) {
                continue;
            }
            for(String id : reporters) {
                countMap.put(id, countMap.getOrDefault(id, 0) + 1);
            }
        }
        
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            int count = countMap.getOrDefault(id_list[i], 0);
            answer[i] = count;
        }
        
        return answer;
    }
}

// 주의할 부분 : 한 사람이 특정 사람을 중복해서 신고해도 최대 1회만 반영된다

// 피고인 - 원고인 Set(신고 당한 횟수)
// 유저 - 신고 접수 횟수
// 반환하는 배열은 id_list의 인덱스 순서와 일치해야 한다.
