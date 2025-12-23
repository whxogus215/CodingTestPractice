import java.util.*;

class Solution {
    
    private int splitIdx = -1;
    
    public String solution(String p) {
        if (p.isEmpty()) {
            return p;
        }
        
        split(p);
        
        String u = p.substring(0, splitIdx);
        String v = p.substring(splitIdx, p.length());
        
        if (isCorrect(u)) {
            return u + solution(v);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(solution(v)).append(")");
        for(int i = 1; i < u.length() -1; i++) {
            char c = u.charAt(i);
            if (c == ')') {
                sb.append("(");
            } else {
                sb.append(")");
            }
        }
        return sb.toString();
    }
    
    private void split(String str) {
        int open = 0;
        int close = 0;
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                splitIdx = i + 1;
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
}