import java.util.*;

class Solution {
    
    private Map<String, Integer> original = new HashMap<>();    
    
    public int solution(String[] want, int[] number, String[] discount) {
        initialize(want, number);
        int answer = 0;
        
        int days = Arrays.stream(number).sum();
        for(int i = 0; i + (days - 1) < discount.length; i++) {
            Map<String, Integer> duplication = new HashMap<>(original);
            for(int j = i; j <= i + (days - 1); j++) {
                if (!duplication.containsKey(discount[j])) {
                    break;
                }
                int remain = duplication.get(discount[j]);
                duplication.put(discount[j], remain - 1);
                if (remain - 1 == 0) {
                    duplication.remove(discount[j]);
                }
            }
            if (duplication.isEmpty()) {
                answer++;   
            }
        }
        
        return answer;
    }
    
    public void initialize(String[] want, int[] number) {
        for(int i = 0; i < want.length; i++) {
            original.put(want[i], number[i]);
        }
    }
}


/**
want와 number를 매핑 (HashMap)
discount를 순차적으로 탐색해야 함
// discount[i]가 Map에 없거나 0일 경우, break;
// 그게 아니면 해당 날짜는 가능
**/