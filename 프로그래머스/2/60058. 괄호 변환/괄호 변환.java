import java.util.*;

class Solution {
    
    private int splitIdx;
    
    public String solution(String p) {
        
        splitIdx = p.length();
        
        if (p.isEmpty()) {
            return p;
        }
        
        doSplit(p);
        
        String u = p.substring(0, splitIdx);
        String v = p.substring(splitIdx, p.length());
        
        if (isCorrect(u)) {
            return u + solution(v);
        }
        
        String result = "(" + solution(v) + ")";
        for(int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                result += ')';
            } else {
                result += '(';
            }
        }
        return result;
    }
    
    private void doSplit(String str) {
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