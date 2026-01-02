import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) {
            return p;
        }
        int splitIdx = split(p);
        String u = p.substring(0, splitIdx);
        String v = p.substring(splitIdx, p.length());
        
        if (isCorrect(u)) {
            return u + solution(v);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(solution(v)).append(")");
        for(int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        
        return sb.toString();
    }
    
    private int split(String str) {
        int splitIdx = -1;
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
                break;
            }
        }
        return splitIdx;
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