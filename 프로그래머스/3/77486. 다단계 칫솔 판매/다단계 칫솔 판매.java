import java.util.*;

class Solution {
    
    public static final int PROFIT = 100;
    
    public static Map<String, String> map = new HashMap<>();
    public static Map<String, Integer> result = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        for(int i = 0; i < enroll.length; i++) {
            String person = enroll[i];
            String refer = referral[i];
            
            map.put(person, refer);
        }
        
        for(int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int totalProfit = amount[i] * PROFIT;
            
            // 재귀 호출
            distribute(name, totalProfit);
        }
        
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < enroll.length; i++) {
            answer.add(result.getOrDefault(enroll[i], 0));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void distribute(String name, int totalProfit) {
        String person = name;
        String referal = map.get(person);

        int remain = (int) (totalProfit * 0.1);
        if (remain > 0) {
            result.put(person, result.getOrDefault(person, 0) + totalProfit - remain);
            distribute(referal, remain);
        } else {
            result.put(person, result.getOrDefault(person, 0) + totalProfit);
        }
    }
}
