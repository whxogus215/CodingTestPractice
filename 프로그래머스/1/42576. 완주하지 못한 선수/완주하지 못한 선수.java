import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> winners = new HashMap<>();
        for(String name : completion) {
            winners.put(name, winners.getOrDefault(name, 0) + 1);
        }
        
        String answer = "";
        for(String name : participant) {
            if (winners.getOrDefault(name, 0) == 0) {
                answer = name;
                break;
            }
            winners.put(name, winners.get(name) - 1);
        }
        
        return answer;
    }
}

// 이름 - 인원 수의 해시 맵 저장(동명이인의 우승자가 있을 수 있으므로, 해시 셋은 사용 못함)
// 이름으로 찾은 인원 수가 0일 경우, 그 사람이 완주하지 못한 자임.