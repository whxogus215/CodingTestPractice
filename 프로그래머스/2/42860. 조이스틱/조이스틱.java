import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1;
        
        for (int i = 0; i < len; i++) {
            char target = name.charAt(i);
            answer += Math.min(target - 'A', 26 - (target - 'A'));
            
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            move = Math.min(move, (i * 2) + (len - next));
            move = Math.min(move, 2 * (len - next) + i);
        }
        answer += move;
        
        return answer;
    }
}