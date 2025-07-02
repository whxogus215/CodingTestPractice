import java.util.*;

class Solution {
    
    private static final String ENTER = "Enter";
    private static final String LEAVE = "Leave";
    private static final String CHANGE = "Change";
    
    public String[] solution(String[] record) {
        Map<String, String> data = new HashMap<>();
        for(String r : record) {
            String[] splited = r.split(" ");
            String command = splited[0];
            if (command.equals(LEAVE)) {
                continue;
            }
            String id = splited[1];
            String name = splited[2];
            
            if (command.equals(ENTER) || command.equals(CHANGE)) {
                data.put(id, name);    
            }
        }
        
        List<String> result = new ArrayList<>();
        for(String r : record) {
            String[] splited = r.split(" ");
            String command = splited[0];
            String id = splited[1];
            
            if (command.equals(ENTER)) {
                result.add(data.get(id) + "님이 들어왔습니다.");
            }
            if (command.equals(LEAVE)) {
                result.add(data.get(id) + "님이 나갔습니다.");
            }
        }
        
        return result.toArray(new String[0]);
    }
}

// Enter와 Leave 때만 메시지 남기기
// Change는 메시지를 남기지 않고, 특정 id의 닉네임만 변경
// record를 순회 -> id와 닉네임 매핑 값 저장 -> 변경 된 값 반영 -> record를 다시 순회하여 출력 결과 저장 : O(N)