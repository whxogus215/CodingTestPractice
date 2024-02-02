package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    public boolean isValid(String s) {
        /**
         * Stack을 활용한 대표적인 문제
         * 1. Stack에는 열린괄호는 저장
         * 2. 닫힐괄호를 만날경우, Stack에 저장된 열린괄호를 pop
         * 3. 다음과 같은 경우에는 false를 반환
         * - 꺼낸 열린괄호와 닫힌괄호가 짝이 안맞을 경우
         * - 그 전에 이미 스택이 비어 있을 경우
         */
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else { // 닫힌 괄호일 경우 - 스택에서 조회
                if (stack.isEmpty() || map.get(stack.pop()) != s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


