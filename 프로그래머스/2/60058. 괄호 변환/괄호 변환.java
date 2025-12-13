import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) {
            return p;
        }
        
        int idx = findSplitIdx(p);
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1, p.length());
        
        if (isCorrect(u)) {
            return u + solution(v);
        }        
        
        String result = '(' + solution(v) + ')';
        
        for(int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                result += ')';
            } else {
                result += '(';
            }
        }
        return result;
    }
    
    private int findSplitIdx(String str) {
        int open = 0;
        int close = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                return i;
            }
        }
        return str.length();
    }
    
    private boolean isCorrect(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : str.toCharArray()) {
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
}