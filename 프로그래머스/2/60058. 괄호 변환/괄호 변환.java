import java.util.*;

class Solution {
    
    private int splitIdx = -1;
    
    private void doSplit(String str) {
        int open = 0;
        int close = 0;
        int idx = 0;
        for(char c : str.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                close++;
            }
            idx++;
            if (open == close) {
                splitIdx = idx;
                return ;
            }
        }
    }
    
    private boolean isCorrect(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for(Character c : str.toCharArray()) {
            if (c == '(') {
                stack.offerFirst(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pollFirst();
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
    
    public String solution(String p) {
        if (p.isEmpty()) {
            return p;
        }
        doSplit(p);
        String u = p.substring(0, splitIdx);
        String v = p.substring(splitIdx, p.length());
        
        if (isCorrect(u)) {
            return u + solution(v);
        }
        
        String answer = "(" + solution(v) + ")";
        for(int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                answer += ')';
            } else {
                answer += '(';
            }
        }
        return answer;
    }
}