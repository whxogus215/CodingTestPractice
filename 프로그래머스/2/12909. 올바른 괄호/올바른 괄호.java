import java.util.Stack;

/**
 * 1. (가 나오면 일단 스택에 저장한다.
 * 2. )가 나오면 스택에서 (를 꺼낸다.
 * 3. 만약, 꺼낼 (가 없을 경우, 이는 잘못된 괄호이다.
 */
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}

