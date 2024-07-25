import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 1. (가 나오면 일단 스택에 저장한다.
 * 2. )가 나오면 스택에서 (를 꺼낸다.
 * 3. 만약, 꺼낼 (가 없을 경우, 이는 잘못된 괄호이다.
 *
 * 스택으로 접근해야 하는 이유 : 짝이 맞는 괄호는 서로 상쇄된다.
 * ==> 가장 최근에 조회한 열린괄호가 먼저 상쇄된다 -> LIFO(FILO) -> 스택!!!
 */
class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] a = s.toCharArray();
        for (char c : a) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() == c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

